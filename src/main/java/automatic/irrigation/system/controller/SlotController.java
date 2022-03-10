package automatic.irrigation.system.controller;

import automatic.irrigation.system.dto.SlotRequest;
import automatic.irrigation.system.entity.Slot;
import automatic.irrigation.system.repository.SlotRepository;
import automatic.irrigation.system.service.impl.SlotServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    SlotRepository slotRepository;

    @Autowired
    SlotServiceImpl slotService;


    @PostMapping(value = "/createSlot")
    public ResponseEntity<?> createPlot(@RequestBody SlotRequest slotRequest) {
        Slot slot = slotService.createSlots(slotRequest);
        if (!Objects.isNull(slot)) {
            return new ResponseEntity<>(slot, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(slot, HttpStatus.BAD_REQUEST);
        }
    }
}
