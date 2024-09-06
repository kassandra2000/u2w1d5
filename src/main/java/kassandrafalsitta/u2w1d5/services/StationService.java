package kassandrafalsitta.u2w1d5.services;

import kassandrafalsitta.u2w1d5.entities.Station;
import kassandrafalsitta.u2w1d5.enums.TypeStation;
import kassandrafalsitta.u2w1d5.exceptions.NotFoundException;
import kassandrafalsitta.u2w1d5.exceptions.ValidationException;
import kassandrafalsitta.u2w1d5.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;
    public void saveStation(List<Station> newStations) {
        newStations.forEach(newStation -> {
            if (stationRepository.existsByDescription(newStation.getDescription()))
                throw new ValidationException("La postazione con descrizione: " + newStation.getDescription() + " è già in utilizzo!");
            if (newStation.getDescription().length() < 2) throw new ValidationException("Descrizione troppo corta!");
            stationRepository.save(newStation);
            System.out.println("Nuova postazione " + newStation.getDescription() + " salvata con successo!");
        });
    }
    public Station findById(UUID stationId) {
        return stationRepository.findById(stationId).orElseThrow(() -> new NotFoundException(stationId));
    }

    public List<Station> findByTypeStationAndBuilding_City( TypeStation typeStation,String city) {
        return stationRepository.findByTypeStationAndBuilding_City( typeStation,city);
    };
}
