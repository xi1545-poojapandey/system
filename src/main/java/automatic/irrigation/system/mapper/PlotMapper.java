package automatic.irrigation.system.mapper;

import automatic.irrigation.system.domain.PlotRequest;
import automatic.irrigation.system.entity.Plot;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlotMapper {

    public Plot mapPlot(PlotRequest plotRequest){
        return Plot.builder().plotArea(plotRequest.getPlotArea())
                .plotId(plotRequest.getPlotId()).plotName(plotRequest.getPlotName()).createdDate(LocalDateTime.now()).build();
    }

}
