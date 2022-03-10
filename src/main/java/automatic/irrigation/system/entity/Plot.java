package automatic.irrigation.system.entity;


import automatic.irrigation.system.enums.IrrigationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plot")
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(name = "plot_name")
    private String plotName;

    @Column(name = "plot_area")
    private long plotArea;

    @Enumerated(value = EnumType.STRING)
    private IrrigationStatus irrigationStatus;

    @Column(name = "crop_name")
    private String cropName;

    @Column(name = "plot_created_date")
    private LocalDateTime createdDate;

    @Column(name = "owned_by")
    private String  ownedBy;

   /* @Column(name = "irrigation_start_Time")
    private LocalDateTime irrigationStartTime;

    @Column(name = "irrigation_end_Time")
    private LocalDateTime irrigationEndTime;*/

}
