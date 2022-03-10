package automatic.irrigation.system.service.impl;

import automatic.irrigation.system.dto.PlotConfigurationRequest;
import automatic.irrigation.system.dto.PlotConfigurationResponse;
import automatic.irrigation.system.dto.PlotRequest;
import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.entity.PlotSlots;
import automatic.irrigation.system.entity.Slot;
import automatic.irrigation.system.enums.SlotStatus;
import automatic.irrigation.system.exception.PlotException;
import automatic.irrigation.system.mapper.PlotMapper;
import automatic.irrigation.system.mapper.PlotSlotMapper;
import automatic.irrigation.system.repository.CropRepository;
import automatic.irrigation.system.repository.PlotRepository;
import automatic.irrigation.system.repository.PlotsSlotsRepository;
import automatic.irrigation.system.repository.SlotRepository;
import automatic.irrigation.system.service.PlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@Component
public class PlotServiceImpl implements PlotService {

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    PlotMapper plotMapper;

    @Autowired
    SlotRepository slotRepository;

    @Autowired
    SlotServiceImpl slotServiceImpl;

    @Autowired
    PlotsSlotsRepository plotsSlotsRepository;

    @Autowired
    CropRepository cropRepository;

    @Autowired
    PlotSlotMapper plotSlotMapper;

    @Override
    public Plot createPlot(PlotRequest plotRequest) {
        return plotRepository.save(plotMapper.mapPlot(plotRequest));
    }


    @Override
    public PlotConfigurationResponse configurePlot(long plotId, PlotConfigurationRequest plotConfigurationRequest) {
        Plot plot = plotRepository.findById(plotId).orElseThrow(NoSuchElementException::new);
        Slot slot =slotRepository.findById(plotConfigurationRequest.getSlotId()).orElseThrow(NoSuchElementException::new);
        PlotSlots plotSlots = PlotSlots.builder()
                .slotId(slot.getId())
                .plotId(plotId)
                .slotStatus(SlotStatus.IRRIGATION_REQUIRED)
                .build();
        plot=plotRepository.save(plotMapper.configurePlot(plotConfigurationRequest,plot));
        plotsSlotsRepository.save(plotSlots);
        List<PlotSlots> plotSlotsList = plotsSlotsRepository.findByPlotId(plotId);

        return PlotConfigurationResponse.builder().plot(plot).plotSlots(plotSlotsList).build();
     }

    @Override
    public Plot editPlot(PlotRequest plotRequest, long id) throws PlotException {

        Optional<Plot> plotAvailable = plotRepository.findById(id);
        Plot plot = null;
        if (plotAvailable.isPresent()) {
            plot = plotAvailable.get();
            plot.setPlotArea(plotRequest.getPlotArea());
            plot.setCreatedDate(LocalDateTime.now());
            plot.setPlotName(plotRequest.getPlotName());
        } else {
            throw new PlotException("plot is not available");

        }

        return plotRepository.save(plot);
    }

    @Override
    public List<Plot> listPlots() {
        return plotRepository.findAll();
    }

    /*public PlotSlots createPlotSlot(PlotSlotRequest plotSlotRequest){
        PlotSlots plotSlots= plotsSlotsRepository.save(plotSlotMapper.mapPlot(plotSlotRequest));
        plotSlots.setPlotId(plotSlotRequest.getPlotId());
        plotSlots.setSlotId(plotSlotRequest.getSlotId());
        plotSlots.setStartTime(LocalDateTime.now());
        plotSlots.setEndTime(LocalDateTime.now().plusMinutes(30));
        return plotsSlotsRepository.save(plotSlots);
    }*/
}
