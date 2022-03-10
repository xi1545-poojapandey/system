package automatic.irrigation.system.scheduling;

import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.entity.PlotSlots;
import automatic.irrigation.system.enums.SlotStatus;
import automatic.irrigation.system.exception.PlotException;
import automatic.irrigation.system.repository.PlotRepository;
import automatic.irrigation.system.repository.PlotsSlotsRepository;
import automatic.irrigation.system.service.impl.IrrigationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CronJobTask {

    private final PlotsSlotsRepository plotsSlotsRepository;

    private final PlotRepository plotRepository;

    private final IrrigationServiceImpl irrigationServiceImpl;

    private int count = 0;

    private final int maxTries = 3;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void irrigatePlot() throws PlotException {
        log.info("Fetch  plots which need to be irrigated");
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusMinutes(30);
        log.info("stat timee {} end timee {} ",startTime, endTime);
        List<PlotSlots> plotsToBeIrrigated = plotsSlotsRepository.findBySlotsTime(startTime, endTime, SlotStatus.IRRIGATION_REQUIRED);
        for(PlotSlots plotSlots : plotsToBeIrrigated) {
            Plot plot = plotRepository.findById(plotSlots.getPlotId()).orElse(null);
            int count = 0;
            while(!irrigationServiceImpl.startIrrigation(plot, plotSlots) &&  count<3) {
                count++;
                try {
                    log.info("inside startIrrigation");
                    Thread.sleep(1000*count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (count == 3
            ) {
                log.info("trigger aleerrt");
            }
        }/*
        List<Long> plotIds = plotsToBeIrrigated.stream().map(PlotSlots::getPlotId).collect(Collectors.toList());
        List<Plot> plots = plotRepository.findAllById(plotIds);
        log.info("plots need to be irrigated: {} ", plots);

        for(Plot plot : plots) {*/

    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void markIrrigationCompleted() {
        log.info("inside markIrrigationCompleted");
            irrigationServiceImpl.completeIrrigation();

    }
}
