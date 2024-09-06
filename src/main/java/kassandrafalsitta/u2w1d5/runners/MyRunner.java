package kassandrafalsitta.u2w1d5.runners;

import kassandrafalsitta.u2w1d5.entities.Building;
import kassandrafalsitta.u2w1d5.entities.Reservation;
import kassandrafalsitta.u2w1d5.entities.Station;
import kassandrafalsitta.u2w1d5.entities.User;
import kassandrafalsitta.u2w1d5.enums.TypeStation;
import kassandrafalsitta.u2w1d5.services.BuildingService;
import kassandrafalsitta.u2w1d5.services.ReservationService;
import kassandrafalsitta.u2w1d5.services.StationService;
import kassandrafalsitta.u2w1d5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class MyRunner implements CommandLineRunner {
    //building
    @Qualifier("officeBuilding")
    @Autowired
    Building officeBuilding;
    @Qualifier("libraryBuilding")
    @Autowired
    Building libraryBuilding;
    @Qualifier("mallBuilding")
    @Autowired
    Building mallBuilding;

    //service
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private StationService stationService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ciao");
        //user
        User mario = getUser("Mario Cross", "mariocross@gmail.com");
        User anna = getUser("Anna Smith", "annasmith@gmail.com");
        User luca = getUser("Luca Bianchi", "lucabianchi@gmail.com");
        //reservations
        Reservation meeticReservation = getReservation(LocalDate.parse("2024-09-05"), "36e37d29-43f4-4082-ae91-51496e4f9827", "d3e547fe-546a-4148-8e7d-36e9975d62c7");
        Reservation privateReservation = getReservation(LocalDate.parse("2024-09-03"), "40d3b241-0588-4a8b-924e-f594b29725df", "b33c4692-855c-408f-8dec-95604636ede8");
        Reservation openSpaceReservation = getReservation(LocalDate.parse("2024-09-06"), "23f5925b-07ea-47be-ab88-06b88ffb7118", "2e280527-a79a-46fd-b296-4db3c8229e51");
//        //save
//        buildingService.saveBuilding(List.of(officeBuilding, libraryBuilding, mallBuilding));
//        stationService.saveStation(List.of(meetingRoomStation, privateOfficeStation, openSpaceStation));
//        userService.saveUser(List.of(mario, anna, luca));
//        reservationService.saveReservation(List.of(meeticReservation, privateReservation, openSpaceReservation));

          //trovare le postazioni in base alla città e al tipo di postazione
          stationService.findByTypeStationAndBuilding_City(TypeStation.SALA_RIUNIONI,"New York" ).forEach(System.out::println) ;
          System.out.println( stationService.findByTypeStationAndBuilding_City( TypeStation.SALA_RIUNIONI,"New York"));



    }

    public User getUser(String name, String email) {
        return new User(name, email);
    }

    public Reservation getReservation(LocalDate validityDate, String userId, String stationId) {
        Station station;
        User user;
        try {
            station = stationService.findById(UUID.fromString(stationId));
        } catch (RuntimeException ex) {
            throw new RuntimeException("Station not found!");
        }
        try {
            user = userService.findById(UUID.fromString(userId));
        } catch (RuntimeException ex) {
            throw new RuntimeException("Station not found!");
        }


        return new Reservation(validityDate, user, station);
    }
}

