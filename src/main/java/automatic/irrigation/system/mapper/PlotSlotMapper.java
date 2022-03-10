package automatic.irrigation.system.mapper;

import automatic.irrigation.system.dto.PlotSlotRequest;
import automatic.irrigation.system.entity.PlotSlots;
import org.springframework.stereotype.Component;

@Component
public class PlotSlotMapper {

    public PlotSlots mapPlot(PlotSlotRequest plotRequest){
        return PlotSlots.builder().plotId(plotRequest.getPlotId()).slotId(plotRequest.getSlotId()).build();
    }

}
