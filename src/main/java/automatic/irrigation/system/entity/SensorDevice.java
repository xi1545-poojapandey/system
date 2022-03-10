package automatic.irrigation.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDevice {

    private String sensors;

    private long  capacity;

    private long capacityAvailable;

    private boolean isAvailable;

    private Map<String,Long> crop;

    }
