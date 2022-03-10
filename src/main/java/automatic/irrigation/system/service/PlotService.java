package automatic.irrigation.system.service;

import automatic.irrigation.system.dto.PlotConfigurationRequest;
import automatic.irrigation.system.dto.PlotConfigurationResponse;
import automatic.irrigation.system.dto.PlotRequest;
import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.exception.PlotException;

import java.util.List;

public interface PlotService {

    Plot createPlot(PlotRequest plotRequest);

    PlotConfigurationResponse configurePlot(long plotId, PlotConfigurationRequest plotConfigurationRequest);

    Plot editPlot(PlotRequest plotRequest,long id) throws PlotException;

    List<Plot> listPlots();
}
