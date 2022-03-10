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
@Table(name = "irrigation_water")
public class IrrigationWater {

    @Id
    @Column(name="id")
    private long id;

    @Column(name = "water_capacity")
    private long waterCapacity;

}
