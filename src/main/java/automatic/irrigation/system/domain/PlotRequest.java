package automatic.irrigation.system.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlotRequest {
    private String plotName;

    private long plotId;

    private long plotArea;

}
