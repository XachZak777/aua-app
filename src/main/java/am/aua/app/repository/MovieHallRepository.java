package am.aua.app.repository;

import am.aua.app.entity.MovieHall;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MovieHallRepository extends JpaRepository<MovieHall, Integer> {
    Optional<MovieHall> findMovieHallById (Integer id);
    MovieHall save(MovieHall movieHall);
}
