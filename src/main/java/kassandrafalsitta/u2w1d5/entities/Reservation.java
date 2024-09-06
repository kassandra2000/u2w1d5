package kassandrafalsitta.u2w1d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {
    @GeneratedValue
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(name = "validity_date")
    private LocalDate validityDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;
    //costruttore
    public Reservation( LocalDate validityDate, User user, Station station) {
        this.validityDate = validityDate;
        this.user = user;
        this.station = station;
    }
    //to string
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", validityDate=" + validityDate +
                ", user=" + user +
                ", station=" + station +
                '}';
    }
}
