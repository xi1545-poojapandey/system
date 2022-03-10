package automatic.irrigation.system.mapper;

import automatic.irrigation.system.dto.SlotRequest;
import automatic.irrigation.system.entity.Slot;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SlotMapper {

    public Slot mapSlot(SlotRequest slotRequest){
        return Slot.builder().irrigationEndTime(LocalDateTime.now().plusMinutes(30))
                .irrigationStartTime(LocalDateTime.now()).build();
    }
}
