package kassandrafalsitta.u2w1d5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "buildings")
public class Building {
    @GeneratedValue
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String address;
    private String city;
    private List<Station> stationList;
    //costruttore
    public Building( String name, String address, String city, List<Station> stationList) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.stationList = stationList;
    }
    //to string
    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", stationList=" + stationList +
                '}';
    }
}
