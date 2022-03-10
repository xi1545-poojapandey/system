package automatic.irrigation.system.entity;

import automatic.irrigation.system.enums.SlotStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "plots_slots")
public class PlotSlots {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "plot_id")
    private long plotId;

    @Column(name = "slot_id")
    private long slotId;

    @Enumerated(value = EnumType.STRING)
    private SlotStatus slotStatus;

}
