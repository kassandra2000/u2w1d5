package kassandrafalsitta.u2w1d5.repositories;

import kassandrafalsitta.u2w1d5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingRepository extends JpaRepository<Building, UUID> {
    boolean existsByName(String name);
}
