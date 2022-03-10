/*
package automatic.irrigation.system.service.impl;

import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.entity.PlotSlots;
import automatic.irrigation.system.enums.IrrigationStatus;
import automatic.irrigation.system.enums.SlotStatus;
import automatic.irrigation.system.repository.PlotRepository;
import automatic.irrigation.system.repository.PlotsSlotsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@Component
public class IrrigationCompleteServiceImpl {

    @Autowired
    private PlotsSlotsRepository plotsSlotsRepository;

    @Autowired
    private PlotRepository plotRepository;


    */
/*   public void checkForIrrigationStatus(Plot plot) {
           List<Plot> plotsIrrigationStarted = plotRepository.findAllByIrrigationEndTime(plot.getIrrigationEndTime());

           for (Plot p : plotsIrrigationStarted) {
               if (Objects.equals(IrrigationStatus.PLOT_IRRIGATION_STARTED, p.getIrrigationStatus())) {
                   if ((plot.getIrrigationStartTime()).isBefore(plot.getIrrigationEndTime())) {
                       plot.setIrrigationStatus(IrrigationStatus.PLOT_IRRRIGATED);
                   } else {
                       plot.setIrrigationStatus(IrrigationStatus.PLOT_IRRIGATION_NOT_COMPLETED);
                   }
               }
           }
       }*//*

    public void completeIrigation() {
        log.info("inside irrigation service complete");
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusMinutes(30);

        List<PlotSlots> plotSlotsList = plotsSlotsRepository.findAllBySlotStatus(SlotStatus.REQUEST_SENT_FOR_IRRIGATION);

        List<Plot> plotsIrrigationStarted = plotRepository.findAllByIrrigationStatus(IrrigationStatus.PLOT_IRRIGATION_STARTED);
        //List<PlotSlots> plotSlotsList = plotsSlotsRepository.findBySlotsTime(startTime, endTime);
        log.info("plots irrigated started  status check: {}", plotsIrrigationStarted);
        for (Plot p : plotsIrrigationStarted) {
            if (Objects.equals(IrrigationStatus.PLOT_IRRIGATION_STARTED, p.getIrrigationStatus())) {
                for (PlotSlots plotSlots : plotSlotsList) {
                    if ((plotSlots.getStartTime()).isAfter(plotSlots.getEndTime())) {
                        p.setIrrigationStatus(IrrigationStatus.PLOT_IRRRIGATED);
                    } else {
                        p.setIrrigationStatus(IrrigationStatus.PLOT_IRRIGATION_NOT_COMPLETED);
                    }
                }
            }
            plotRepository.save(p);
        }
    }
}
*/
