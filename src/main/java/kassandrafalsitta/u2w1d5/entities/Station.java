package kassandrafalsitta.u2w1d5.entities;

import jakarta.persistence.*;
import kassandrafalsitta.u2w1d5.enums.StateStation;
import kassandrafalsitta.u2w1d5.enums.TypeStation;
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
@Table(name = "stations")
public class Station {
    @GeneratedValue
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String description;
    @Column(name = "state_station")
    @Enumerated(EnumType.STRING)
    private StateStation stateStation;
    @Column(name = "type_station")
    @Enumerated(EnumType.STRING)
    private TypeStation typeStation;
    @Column(name = "maximum_num_occupants")
    private int maximumNumOfOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @OneToMany(mappedBy = "station")
    private List<Reservation> reservationList;
    //costruttore
    public Station( String description, StateStation stateStation, TypeStation typeStation, int maximumNumOfOccupants, Building building) {
        this.description = description;
        this.stateStation = stateStation;
        this.typeStation = typeStation;
        this.maximumNumOfOccupants = maximumNumOfOccupants;
        this.building = building;
    }
    //to string
    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", stateStation=" + stateStation +
                ", typeStation=" + typeStation +
                ", maximumNumOfOccupants=" + maximumNumOfOccupants +
                ", building=" + building +
                ", reservationList=" + reservationList +
                '}';
    }
}
