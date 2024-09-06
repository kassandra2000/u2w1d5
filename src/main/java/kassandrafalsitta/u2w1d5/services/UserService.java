package kassandrafalsitta.u2w1d5.services;

import kassandrafalsitta.u2w1d5.entities.Station;
import kassandrafalsitta.u2w1d5.entities.User;
import kassandrafalsitta.u2w1d5.exceptions.NotFoundException;
import kassandrafalsitta.u2w1d5.exceptions.ValidationException;
import kassandrafalsitta.u2w1d5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(List<User> newUsers) {
        newUsers.forEach(newUser -> {
            if (userRepository.existsByFullName(newUser.getFullName()))
                throw new ValidationException("L' utente con nome: " + newUser.getFullName() + " è già in utilizzo!");
            if (newUser.getFullName().length() < 2) throw new ValidationException("Nome troppo corto!");
            userRepository.save(newUser);
            System.out.println("Nuovo utente " + newUser.getFullName() + " salvato con successo!");
        });

    }
    public User findById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId));
    }
}
