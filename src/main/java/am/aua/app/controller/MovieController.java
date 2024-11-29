package am.aua.app.controller;

import am.aua.app.dto.MovieRequest;
import am.aua.app.entity.Movie;
import am.aua.app.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(Integer id) {
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createMovie(@RequestBody MovieRequest movieRequest) {
        return ResponseEntity.ok(movieService.createMovie(movieRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie (@PathVariable("id") Integer id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.ok(String.format("Movie with %s id is not found", id));
    }
}
