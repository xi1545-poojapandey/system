package automatic.irrigation.system.repository;

import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.enums.IrrigationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface PlotRepository extends JpaRepository<Plot, Long> {


    @Override
    Optional<Plot> findById(Long id);

    List<Plot> findAllByIrrigationStatus(IrrigationStatus status);

    //Optional<Plot> findByPlotId(long plotId);
}
