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
    @Enumerated(EnumType.STRING)
    private StateStation stateStation;
    @Enumerated(EnumType.STRING)
    private TypeStation typeStation;
    private int maximumNumOfOccupants;
    private Building building;
    private List<Reservation> reservationList;
    //costruttore


}
