package am.aua.app.controller;

import am.aua.app.dto.MovieRequest;
import am.aua.app.entity.Movie;
import am.aua.app.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/findAllMovies")
    public ResponseEntity<List<Movie>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @PostMapping("/createMovie")
    public ResponseEntity<?> createMovie(@RequestBody MovieRequest movieRequest) {
        return ResponseEntity.ok(movieService.createMovie(movieRequest));
    }
}
