package kassandrafalsitta.u2w1d5.config;

import kassandrafalsitta.u2w1d5.entities.Station;
import kassandrafalsitta.u2w1d5.enums.StateStation;
import kassandrafalsitta.u2w1d5.enums.TypeStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class StationConfig {
    @Autowired
    private BuildingConfig buildingConfig;

    @Bean(name = "meetingRoomStation")
    public Station getMeetingRoomStation() {
        return new Station("Postazione in sala riunioni, perfetta per incontri di lavoro.",
                StateStation.OCCUPATO,
                TypeStation.SALA_RIUNIONI,
                8,
                buildingConfig.getOfficeBuilding());
    }

    @Bean(name = "privateOfficeStation")
    public Station getPrivateOfficeStation() {
        return new Station("Postazione in ufficio privato, ideale per lavoro concentrato.",
                StateStation.LIBERO,
                TypeStation.PRIVATO,
                1,
                buildingConfig.getMallBuilding());
    }

    @Bean(name = "openSpaceStation")
    public Station getOpenSpaceStation() {
        return new Station("Postazione in open space, progettata per il lavoro collaborativo.",
                StateStation.LIBERO,
                TypeStation.OPEN_SPACE,
                20,
                buildingConfig.getLibraryBuilding());
    }
}
