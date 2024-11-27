package am.aua.app.repository;

import am.aua.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByID (Integer id);

    User save(User user);
}