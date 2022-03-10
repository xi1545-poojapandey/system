package automatic.irrigation.system.service.impl;

import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.entity.PlotSlots;
import automatic.irrigation.system.entity.SensorDevice;
import automatic.irrigation.system.enums.IrrigationStatus;
import automatic.irrigation.system.enums.SlotStatus;
import automatic.irrigation.system.repository.PlotRepository;
import automatic.irrigation.system.repository.PlotsSlotsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IrrigationServiceImpl {

    private List<SensorDevice> sensors = new ArrayList<>();
    private Map<String, Long> cropMap = new HashMap<>();
    private int retryCount = 3;
    private long delay = 1000;

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private PlotsSlotsRepository plotsSlotsRepository;

    @PostConstruct
    public void sensorConfigureMock() {

        cropMap.put("Wheat", 100L);
        cropMap.put("Bajra", 100L);
        cropMap.put("Corn", 100L);

        SensorDevice sensorDeviceA = new SensorDevice("A", 100L, 100L, true, cropMap);
        SensorDevice sensorDeviceB = new SensorDevice("B", 10000L, 100L, true, cropMap);
        SensorDevice sensorDeviceC = new SensorDevice("C", 100L, 100L, true, cropMap);

        sensors.add(sensorDeviceA);
        sensors.add(sensorDeviceB);
        sensors.add(sensorDeviceC);
    }

    public boolean startIrrigation(Plot plot, PlotSlots plotSlots) {
        boolean isIrrigationStarted = false;
        log.info("plot area {} end crop name {} ", plot.getPlotArea(), plot.getCropName());
        List<SensorDevice> list = sensors.stream().filter(p -> p.getCrop().containsKey(plot.getCropName()) && p.isAvailable()).
                collect(Collectors.toList());
        long waterRequired = plot.getPlotArea() * cropMap.get(plot.getCropName());
        log.info("water required:{}", waterRequired);
        if (!CollectionUtils.isEmpty(list)) {
            if(updateStatusIfIrrigationStarts(plot, list, waterRequired)) {
                plotSlots.setSlotStatus(SlotStatus.REQUEST_SENT_FOR_IRRIGATION);
                plotsSlotsRepository.save(plotSlots);
                isIrrigationStarted = true;
            }
        }
        return isIrrigationStarted;
    }

    private boolean updateStatusIfIrrigationStarts(Plot plot, List<SensorDevice> list, long waterRequired) {
        boolean flag = false;
        for (SensorDevice s : list) {
            if (s.getCapacity() >= waterRequired) {
                long residual = Math.subtractExact(s.getCapacity(), waterRequired);
                if (residual >= 0) {
                    s.setCapacityAvailable(residual);
                    plot.setIrrigationStatus(IrrigationStatus.PLOT_IRRIGATION_STARTED);
                    flag = true;
                    break;
                } else {
                    s.setCapacityAvailable(0);
                    s.setAvailable(false);
                    plot.setIrrigationStatus(IrrigationStatus.RETRY);
                }
            }
        }
        plotRepository.save(plot);
        return flag;
    }

    public void completeIrrigation() {
        log.info("inside irrigation service complete");
        List<PlotSlots> plotSlotsList = plotsSlotsRepository.findAllBySlotStatus(SlotStatus.REQUEST_SENT_FOR_IRRIGATION);
        List<Plot> plotsIrrigationStarted = plotRepository.findAllByIrrigationStatus(IrrigationStatus.PLOT_IRRIGATION_STARTED);
        log.info("plots irrigated started  status check: {}", plotsIrrigationStarted);

        for (PlotSlots p : plotSlotsList) {
            if (Objects.equals(SlotStatus.REQUEST_SENT_FOR_IRRIGATION, p.getSlotStatus())) {
                for (Plot plot : plotsIrrigationStarted) {
                    if (Objects.equals(IrrigationStatus.PLOT_IRRIGATION_STARTED, plot.getIrrigationStatus())
                            && Objects.equals(SlotStatus.REQUEST_SENT_FOR_IRRIGATION, p.getSlotStatus())) {
                        plot.setIrrigationStatus(IrrigationStatus.PLOT_IRRRIGATED);
                        p.setSlotStatus(SlotStatus.IRRIGATION_REQUEST_COMPLETED);
                        List<SensorDevice> list = sensors.stream().filter(x -> x.getCrop().containsKey(plot.getCropName()) && x.isAvailable()).
                                collect(Collectors.toList());
                        for (SensorDevice s : list) {
                            s.setAvailable(true);
                            s.setCapacityAvailable(s.getCapacity());
                        }

                    } else {
                        plot.setIrrigationStatus(IrrigationStatus.PLOT_IRRIGATION_NOT_COMPLETED);
                    }
                    plotRepository.save(plot);
                }
            }plotsSlotsRepository.save(p);
        }
    }
}
