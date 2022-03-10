package automatic.irrigation.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Builder
@Data
@Entity
@Table(name = "slots")
@RequiredArgsConstructor
@AllArgsConstructor
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "irrigation_start_time")
    private  LocalDateTime irrigationStartTime;

    @JsonIgnore
    @Column(name = "irrigation_end_time")
    private  LocalDateTime irrigationEndTime;

    /*@Column(name = "slot_available")
    private long  slotAvailable;

    @Column(name = "slot_booked")
    private long slotBooked;

    @Column(name="plot_id")
    private long plotId;*/


}
