package automatic.irrigation.system.service;

import automatic.irrigation.system.TestHelper;
import automatic.irrigation.system.entity.Slot;
import automatic.irrigation.system.mapper.SlotMapper;
import automatic.irrigation.system.repository.SlotRepository;
import automatic.irrigation.system.service.impl.SlotServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SlotServiceTest {

    @InjectMocks
    SlotServiceImpl slotService;

    @Mock
    SlotRepository slotRepository;

    @Mock
    SlotMapper slotMapper;

    @Test
    public void test_create_slot(){
        Slot slot= TestHelper.createSlot();
        when(slotRepository.save(any())).thenReturn(slot);
        slot=slotService.createSlots(TestHelper.createSlotRequest());
        assertNotNull(slot);


    }
}
