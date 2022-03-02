package automatic.irrigation.system.repository;

import automatic.irrigation.system.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PlotRepository extends JpaRepository<Plot, Long> {


    @Override
    Optional<Plot> findById(Long aLong);

    Optional<Plot> findByPlotId(long plotId);
}
