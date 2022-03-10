package automatic.irrigation.system.controller;

import automatic.irrigation.system.dto.PlotConfigurationRequest;
import automatic.irrigation.system.dto.PlotConfigurationResponse;
import automatic.irrigation.system.dto.PlotRequest;
import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.repository.PlotRepository;
import automatic.irrigation.system.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/plot")
public class PlotController {

    @Autowired
    PlotService plotService;
    @Autowired
    PlotRepository plotRepository;


    @PostMapping(value = "/create")
    public ResponseEntity<?> createPlot(@RequestBody PlotRequest plotRequest) {
        Plot plot = plotService.createPlot(plotRequest);
        return new ResponseEntity<>(plot, HttpStatus.CREATED);
    }


    @GetMapping("/fetchPlot")
    public ResponseEntity<List<Plot>> fetchPlot() {
        List<Plot> plot = plotService.listPlots();
        if (!Objects.isNull(plot)) {
            return new ResponseEntity<>(plot, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/configurePlot/{plotId}")
    public ResponseEntity<PlotConfigurationResponse> configurePlot(@PathVariable(value = "plotId") long plotId, @RequestBody PlotConfigurationRequest plotConfigurationRequest) {

        PlotConfigurationResponse plotConfigurationResponse = plotService.configurePlot(plotId, plotConfigurationRequest);
        if (!Objects.isNull(plotConfigurationResponse)) {
            return new ResponseEntity<>(plotConfigurationResponse, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    /*@PostMapping("/createPlotSlots")
    public ResponseEntity<?> createPlotSlots(@RequestBody PlotSlotRequest slotRequest) {

        PlotSlots slots = plotService.createPlotSlot(slotRequest);
        if (!Objects.isNull(slots)) {
            return new ResponseEntity<>(slots, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(slots, HttpStatus.BAD_REQUEST);
        }

    }*/
}
