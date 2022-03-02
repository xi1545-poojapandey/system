package automatic.irrigation.system.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@Table(name = "plot")
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(name = "plot_name")
    private String plotName;

    @Column(name = "plot_id")
    private long plotId;

    @Column(name = "plot_area")
    private long plotArea;

    @Column(name = "plot_created_date")
    private LocalDateTime createdDate;
}
