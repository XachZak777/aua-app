package am.aua.app.repository;

import am.aua.app.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    Optional<Screening> findScreeningById (Integer id);
    Screening save(Screening screening);
}
