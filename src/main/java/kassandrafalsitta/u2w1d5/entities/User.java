package kassandrafalsitta.u2w1d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @GeneratedValue
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservationsList ;
    //costruttore
    public User( String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
        this.reservationsList =new ArrayList<>();
    }
    //to string
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                //", reservationsList=" + reservationsList +
                '}';
    }
}
