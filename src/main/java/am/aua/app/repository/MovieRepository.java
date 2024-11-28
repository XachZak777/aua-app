package am.aua.app.repository;

import am.aua.app.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findMovieById (Integer id);
    Movie save(Movie movie);
}
