package automatic.irrigation.system.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlotSlotRequest {

    private long plotId;

    private long slotId;

}
