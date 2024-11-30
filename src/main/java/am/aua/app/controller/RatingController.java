package am.aua.app.controller;

import am.aua.app.dto.PaymentRequest;
import am.aua.app.dto.RatingRequest;
import am.aua.app.entity.Payment;
import am.aua.app.entity.Rating;
import am.aua.app.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> findAllRatings() {
        return ResponseEntity.ok(ratingService.findAllRatings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> findRatingById(Integer id) {
        return ResponseEntity.ok(ratingService.findRatingById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createRating(@RequestBody RatingRequest ratingRequest) {
        return ResponseEntity.ok(ratingService.createRating(ratingRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable("id") Integer id) {
        ratingService.deleteRatingById(id);
        return ResponseEntity.ok(String.format("Payment with %s id is not found", id));
    }
}
