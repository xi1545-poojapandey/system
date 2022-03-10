package automatic.irrigation.system.repository;

import automatic.irrigation.system.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface SlotRepository extends JpaRepository<Slot,Long> {
    Slot findById(long plotId);

    //Slot findByPlotId(long plotId);
}
