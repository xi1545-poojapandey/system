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
@Table(name = "alert")
public class Alert {

    @Id
    @Column(name="id")
    private long id;


    @Column(name = "plot_id")
    private long  plotId;

}
