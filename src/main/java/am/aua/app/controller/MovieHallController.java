package am.aua.app.controller;

import am.aua.app.dto.MovieHallRequest;
import am.aua.app.entity.MovieHall;
import am.aua.app.service.MovieHallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movieHall")
@RequiredArgsConstructor
public class MovieHallController {

    private final MovieHallService movieHallService;

    @GetMapping("/all")
    public ResponseEntity<List<MovieHall>> findAllMovieHalls() {
        return ResponseEntity.ok(movieHallService.findAllMovieHalls());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieHall> findMovieHallById(Integer id) {
        return ResponseEntity.ok(movieHallService.findMovieHallById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createMovieHall(@RequestBody MovieHallRequest movieHallRequest) {
        return ResponseEntity.ok(movieHallService.createMovieHall(movieHallRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieHall(@PathVariable("id") Integer id) {
        movieHallService.deleteMovieHallById(id);
        return ResponseEntity.ok(String.format("Movie Hall with %s id is not found", id));
    }
}
