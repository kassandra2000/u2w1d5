package kassandrafalsitta.u2w1d5.config;

import kassandrafalsitta.u2w1d5.entities.Building;
import kassandrafalsitta.u2w1d5.entities.Station;
import kassandrafalsitta.u2w1d5.enums.StateStation;
import kassandrafalsitta.u2w1d5.enums.TypeStation;
import kassandrafalsitta.u2w1d5.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.UUID;

@Configuration
@PropertySource("application.properties")
public class StationConfig {
    @Autowired
    private BuildingRepository buildingRepository;

    @Bean(name = "meetingRoomStation")
    public Station getMeetingRoomStation() {
        Building officeBuilding = buildingRepository.findById(UUID.fromString("67fb6d08-924a-4fbd-9204-f40850ed6fe0")).orElseThrow(() -> new RuntimeException("Office Building non trovato!"));
        return new Station("Postazione in sala riunioni, perfetta per incontri di lavoro.",
                StateStation.OCCUPATO,
                TypeStation.SALA_RIUNIONI,
                8, officeBuilding);
    }

    @Bean(name = "privateOfficeStation")
    public Station getPrivateOfficeStation() {
        Building mallBuilding = buildingRepository.findById(UUID.fromString("4de0c654-1483-4afd-b519-3d4197effa9a")).orElseThrow(() -> new RuntimeException("Mall Building non trovato!"));
        return new Station("Postazione in ufficio privato, ideale per lavoro concentrato.",
                StateStation.LIBERO,
                TypeStation.PRIVATO,
                1,
               mallBuilding);
    }

    @Bean(name = "openSpaceStation")
    public Station getOpenSpaceStation() {
        Building libraryBuilding = buildingRepository.findById(UUID.fromString("58b6de59-4aa4-4fcc-b968-64b293c44d85")).orElseThrow(() -> new RuntimeException("Library Building non trovato!"));

        return new Station("Postazione in open space, progettata per il lavoro collaborativo.",
                StateStation.LIBERO,
                TypeStation.OPENSPACE,
                20,
                libraryBuilding);
    }
}
