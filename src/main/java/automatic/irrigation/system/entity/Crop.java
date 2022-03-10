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
@Table(name = "crop")
public class Crop {

    @Id
    @Column(name="id")
    private long id;

    @Column(name = "crop_name")
    private String cropName;

    @Column(name = "water_required")
    private long  waterRequired;
}
