package automatic.irrigation.system.service;

import automatic.irrigation.system.PlotService;
import automatic.irrigation.system.domain.PlotRequest;
import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.mapper.PlotMapper;
import automatic.irrigation.system.repository.PlotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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


    @Override
    public Plot createPlot(PlotRequest plotRequest) {
        Plot plot = null;

        try {
            plot = plotRepository.save(plotMapper.mapPlot(plotRequest));
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return plot;

    }


    @Override
    public Plot configurePlot(PlotRequest plotRequest) {
        return null;
    }

    @Override
    public Plot editPlot(PlotRequest plotRequest) {

        Optional<Plot> plotOptional= plotRepository.findById(plotRequest.getPlotId());
        Plot plot=null;
        if(plotOptional.isPresent()){
            plot=plotOptional.get();
            plot.setPlotArea(plotRequest.getPlotArea());
            plot.setCreatedDate(LocalDateTime.now());
            plot.setPlotId(plotRequest.getPlotId());
            plot.setPlotName(plotRequest.getPlotName());
        }else{
            throw new RuntimeException();

        }

        return plot;
    }

    @Override
    public Optional<Plot>fetchPlot(long plotId) {

        return Optional.ofNullable(plotRepository.findByPlotId(plotId).orElseThrow(() -> new NoSuchElementException()));
    }
}
