package kassandrafalsitta.u2w1d5.services;

import kassandrafalsitta.u2w1d5.entities.Reservation;
import kassandrafalsitta.u2w1d5.enums.StateStation;
import kassandrafalsitta.u2w1d5.exceptions.ValidationException;
import kassandrafalsitta.u2w1d5.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void saveReservation(List<Reservation> newReservations) {
        newReservations.forEach(newReservation -> {
            if (reservationRepository.existsByValidityDate(newReservation.getValidityDate())) {
                throw new ValidationException("La prenotazione con data: " + newReservation.getValidityDate() + " è già in utilizzo!");
            }

            newReservation.getStation().setStateStation(StateStation.OCCUPATO);
            reservationRepository.save(newReservation);
            System.out.println("Nuova prenotazione con data" + newReservation.getValidityDate() + " salvata con successo!");
            System.out.println("la postazione con descrizione" + newReservation.getStation().getDescription() + " ha cambiato lo stato con: "+newReservation.getStation().getStateStation());

            LocalDate nextDay = newReservation.getValidityDate().plusDays(1);
            if(newReservation.getValidityDate().isBefore(nextDay)){
                newReservation.getStation().setStateStation(StateStation.LIBERO);
                reservationRepository.save(newReservation);
            }
        });
    }
}
