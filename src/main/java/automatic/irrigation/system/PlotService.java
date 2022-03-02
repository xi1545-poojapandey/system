package automatic.irrigation.system;

import automatic.irrigation.system.domain.PlotRequest;
import automatic.irrigation.system.entity.Plot;

import java.util.Optional;

public interface PlotService {

    Plot createPlot(PlotRequest plotRequest);

    Plot configurePlot(PlotRequest plotRequest);

    Plot editPlot(PlotRequest plotRequest);

    Optional<Plot> fetchPlot(long plotId);
}
