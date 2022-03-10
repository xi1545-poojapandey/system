package automatic.irrigation.system.service;

import automatic.irrigation.system.dto.SlotRequest;
import automatic.irrigation.system.entity.Slot;

public interface SlotService {

    Slot createSlots(SlotRequest slotRequest);

    Slot editSlots(SlotRequest slotRequest);

    Slot updateSlots();

}
