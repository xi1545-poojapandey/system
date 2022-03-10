package automatic.irrigation.system.repository;

import automatic.irrigation.system.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface CropRepository extends JpaRepository<Crop,Long> {
    List<String> findByCropName(String cropName);
}
