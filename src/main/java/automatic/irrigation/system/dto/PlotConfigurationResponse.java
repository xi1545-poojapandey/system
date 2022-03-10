package automatic.irrigation.system.dto;

import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.entity.PlotSlots;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PlotConfigurationResponse {
    private Plot plot;
    private List<PlotSlots> plotSlots;
}
