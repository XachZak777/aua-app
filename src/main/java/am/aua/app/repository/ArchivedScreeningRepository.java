package am.aua.app.repository;

import am.aua.app.entity.ArchivedScreening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArchivedScreeningRepository extends JpaRepository<ArchivedScreening, Integer> {
    Optional<ArchivedScreening> findArchivedScreeningById (Integer id);
    ArchivedScreening save(ArchivedScreening archivedScreening);
}
