package am.aua.app.repository;

import am.aua.app.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    Optional<Rating> findRatingById (Integer id);
    Rating save(Rating rating);
}
