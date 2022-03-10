package automatic.irrigation.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlotRequest {
    private String plotName;
    private long plotArea;
    private String ownedBy;
}
