package kassandrafalsitta.u2w1d5.repositories;

import kassandrafalsitta.u2w1d5.entities.Building;
import kassandrafalsitta.u2w1d5.entities.Station;
import kassandrafalsitta.u2w1d5.enums.TypeStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {
    boolean existsByDescription(String description);
    //uso il trattino basso perche è una convezione per specificare relazioni tra entità


    List<Station> findByTypeStationAndBuildingCity( TypeStation typeStation,String city);

}
