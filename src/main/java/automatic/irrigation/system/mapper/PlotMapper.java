package automatic.irrigation.system.mapper;

import automatic.irrigation.system.dto.PlotConfigurationRequest;
import automatic.irrigation.system.dto.PlotRequest;
import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.enums.IrrigationStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlotMapper {

    public Plot mapPlot(PlotRequest plotRequest){
        return Plot.builder().plotArea(plotRequest.getPlotArea())
                .plotName(plotRequest.getPlotName()).irrigationStatus(IrrigationStatus.PLOT_IRRIGATION_NOT_STARTED)
                        .ownedBy(plotRequest.getOwnedBy())
                        .createdDate(LocalDateTime.now()).build();
    }

    public Plot configurePlot(PlotConfigurationRequest plotConfigurationRequestRequest, Plot  plot){
        return plot.builder()
                .cropName(plotConfigurationRequestRequest.getCropName())
                .build();
    }
}
