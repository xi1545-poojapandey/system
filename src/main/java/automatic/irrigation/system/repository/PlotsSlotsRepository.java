package automatic.irrigation.system.repository;

import automatic.irrigation.system.entity.PlotSlots;
import automatic.irrigation.system.enums.SlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

@EnableJpaRepositories
public interface PlotsSlotsRepository extends JpaRepository<PlotSlots, Long> {
    List<PlotSlots> findByPlotId(long plotId);

    @Query(value = "SELECT t from PlotSlots t inner join automatic.irrigation.system.entity.Slot s on s.id = t.slotId " +
            "where s.irrigationStartTime <=:startTime AND s.irrigationEndTime<=:endTime AND  t.slotStatus=:slotStatus")
    List<PlotSlots> findBySlotsTime(@Param("startTime") LocalDateTime startTime, @Param("endTime")LocalDateTime endTime, SlotStatus slotStatus);

    List<PlotSlots> findAllBySlotStatus(SlotStatus requestSentForIrrigation);
}


