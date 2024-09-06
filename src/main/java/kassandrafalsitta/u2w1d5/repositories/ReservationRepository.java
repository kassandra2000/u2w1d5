package kassandrafalsitta.u2w1d5.repositories;

import kassandrafalsitta.u2w1d5.entities.Building;
import kassandrafalsitta.u2w1d5.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    boolean existsByValidityDate(LocalDate validityDate);
}
