package automatic.irrigation.system.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@Entity
@Table(name = "crop_irrigation")
public class CropIrigation {

    @Id
    @Column(name="id")
    private long id;

    @Column(name = "crop_id")
    private long cropId;

    @Column(name = "irrigation_water_id")
    private long irrigationWaterId;
}
