package automatic.irrigation.system.dto;


import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class PlotsResponse {

    private String plotName;

    private long plotId;

    private long plotArea;

}
