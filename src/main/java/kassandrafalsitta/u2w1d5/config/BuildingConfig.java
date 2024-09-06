package kassandrafalsitta.u2w1d5.config;

import kassandrafalsitta.u2w1d5.entities.Building;
import kassandrafalsitta.u2w1d5.entities.Station;
import kassandrafalsitta.u2w1d5.enums.StateStation;
import kassandrafalsitta.u2w1d5.enums.TypeStation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class BuildingConfig {
    @Bean(name = "officeBuilding")
    public Building getOfficeBuilding() {
        return new Building("Office Building","123 Main St","New York");
    }
    @Bean(name = "libraryBuilding")
    public Building getLibraryBuilding() {
        return new Building("Library Building", "101 Oak St", "San Francisco");
    }
    @Bean(name = "mallBuilding")
    public Building getMallBuilding() {
        return new Building("Mall Building", "303 Cedar Ave", "Miami");
    }
}
