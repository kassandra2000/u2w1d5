package kassandrafalsitta.u2w1d5.repositories;

import kassandrafalsitta.u2w1d5.entities.Building;
import kassandrafalsitta.u2w1d5.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StationRepository extends JpaRepository<Station, UUID> {
    boolean existsByDescription(String description);
}
