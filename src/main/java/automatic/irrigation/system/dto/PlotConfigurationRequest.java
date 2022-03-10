package automatic.irrigation.system.dto;

import lombok.Data;

@Data
public class PlotConfigurationRequest {

    private String cropName;
    private Long slotId;
}
