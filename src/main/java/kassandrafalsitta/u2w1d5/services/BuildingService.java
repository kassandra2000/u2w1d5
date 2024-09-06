package kassandrafalsitta.u2w1d5.services;

import kassandrafalsitta.u2w1d5.entities.Building;
import kassandrafalsitta.u2w1d5.exceptions.NotFoundException;
import kassandrafalsitta.u2w1d5.exceptions.ValidationException;
import kassandrafalsitta.u2w1d5.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public void saveBuilding(List<Building> newBuildings) {
        newBuildings.forEach(newBuilding -> {
            if (buildingRepository.existsByName(newBuilding.getName()))
                throw new ValidationException("L' edificio con nome: " + newBuilding.getName() + " è già in utilizzo!");
            if (newBuilding.getName().length() < 2) throw new ValidationException("Nome troppo corto!");
            buildingRepository.save(newBuilding);
            System.out.println("Nuovo edificio " + newBuilding.getName() + " salvato con successo!");
        });
    }

    public Building findById(UUID buildingId) {
        return buildingRepository.findById(buildingId).orElseThrow(() -> new NotFoundException(buildingId));
    }
}
