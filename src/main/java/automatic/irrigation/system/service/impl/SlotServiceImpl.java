package automatic.irrigation.system.service.impl;

import automatic.irrigation.system.dto.SlotRequest;
import automatic.irrigation.system.entity.Slot;
import automatic.irrigation.system.mapper.SlotMapper;
import automatic.irrigation.system.repository.SlotRepository;
import automatic.irrigation.system.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotServiceImpl implements SlotService {


    @Autowired
    SlotRepository slotRepository;

    @Autowired
    SlotMapper slotMapper;

    @Override
    public Slot createSlots(SlotRequest slotRequest) {
       Slot slot = slotRepository.save(slotMapper.mapSlot(slotRequest));
       return slotRepository.save(slot);
    }

    @Override
    public Slot editSlots(SlotRequest slotRequest) {
        return null;
    }

    @Override
    public Slot updateSlots() {
        return null;

    }
}

