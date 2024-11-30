package am.aua.app.service;

import am.aua.app.dto.MovieHallRequest;
import am.aua.app.entity.MovieHall;
import am.aua.app.exception.MovieHallNotFoundException;
import am.aua.app.repository.MovieHallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieHallService {

    private final MovieHallRepository movieHallRepository;

    public List<MovieHall> findAllMovieHalls () {
        return movieHallRepository.findAll();
    }

    public MovieHall findMovieHallById (Integer movieHallId) {
        return movieHallRepository.findMovieHallById(movieHallId).orElseThrow(() ->
                new MovieHallNotFoundException("MovieHall not found!")
        );
    }

    public MovieHall createMovieHall (MovieHallRequest movieHallRequest) {
        var savedMovieHall = movieHallRepository.save(
                MovieHall.builder()
                        .hallName(movieHallRequest.getHallName())
                        .capacity(movieHallRequest.getCapacity())
                        .features(movieHallRequest.getFeatures())
                        .hallStatus(movieHallRequest.getHallStatus())
                        .build()
        );
        return savedMovieHall;
    }

    public void deleteMovieHallById (Integer id) {
        MovieHall movieHall = movieHallRepository.findMovieHallById(id).orElseThrow(() -> new MovieHallNotFoundException("MovieHall not found!"));
        movieHallRepository.deleteById(id);
    }
}
