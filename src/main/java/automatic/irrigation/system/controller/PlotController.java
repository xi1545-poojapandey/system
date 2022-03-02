package automatic.irrigation.system.controller;

import automatic.irrigation.system.domain.PlotRequest;
import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.repository.PlotRepository;
import automatic.irrigation.system.service.PlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/irrigation")
public class PlotController {

    @Autowired
    PlotServiceImpl plotServiceImpl;

    @Autowired
    PlotRepository plotRepository;


    @PostMapping(value = "/create")
    public ResponseEntity<?> createPlot(@RequestBody PlotRequest plotRequest){
        Plot plot= plotServiceImpl.createPlot(plotRequest);
        if(!Objects.isNull(plot)){
            return new ResponseEntity<>(plot, HttpStatus.CREATED);
        }

        else{
            return new ResponseEntity<>(plot,HttpStatus.BAD_REQUEST);
        }
    }

}
