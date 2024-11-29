package am.aua.app.service;

import am.aua.app.dto.MovieRequest;
import am.aua.app.entity.Actor;
import am.aua.app.entity.Movie;
import am.aua.app.exception.ActorNotFoundException;
import am.aua.app.exception.MovieNotFoundException;
import am.aua.app.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> findAllMovies () {
        return movieRepository.findAll();
    }

    public Movie findMovieById (Integer movieId) {
        return movieRepository.findMovieById(movieId).orElseThrow(() ->
                new MovieNotFoundException("Movie not found!")
        );
    }

    public Movie createMovie (MovieRequest movieRequest) {
        var savedMovie = movieRepository.save(
                Movie.builder()
                        .title(movieRequest.getTitle())
                        .description(movieRequest.getDescription())
                        .duration(movieRequest.getDuration())
                        .genre(movieRequest.getGenre())
                        .releaseDate(movieRequest.getReleaseDate())
                        .rating(movieRequest.getRating())
                        .build()
        );
        return savedMovie;
    }

    public void deleteMovieById (Integer id) {
        Movie movie = movieRepository.findMovieById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found!"));
        movieRepository.deleteById(id);
    }
}
