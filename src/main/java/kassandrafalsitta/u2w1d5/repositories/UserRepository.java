package kassandrafalsitta.u2w1d5.repositories;

import kassandrafalsitta.u2w1d5.entities.Building;
import kassandrafalsitta.u2w1d5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByFullName(String fullName);
}
