package am.aua.app.service;

import am.aua.app.dto.RatingRequest;
import am.aua.app.entity.Rating;
import am.aua.app.exception.RatingNotFoundException;
import am.aua.app.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public List<Rating> findAllRatings () {
        return ratingRepository.findAll();
    }

    public Rating findRatingById (Integer ratingId) {
        return ratingRepository.findRatingById(ratingId).orElseThrow(() ->
                new RatingNotFoundException("Rating not found!")
        );
    }

    public Rating createRating (RatingRequest ratingRequest) {
        var savedRating = ratingRepository.save(
                Rating.builder()
                        .movie(ratingRequest.getMovie())
                        .customer(ratingRequest.getCustomer())
                        .ratingValue(ratingRequest.getRatingValue())
                        .review(ratingRequest.getReview())
                        .ratingDate(ratingRequest.getRatingDate())
                        .ratingTime(ratingRequest.getRatingTime())
                        .build()
        );
        return savedRating;
    }

    public void deleteRatingById (Integer id) {
        Rating rating = ratingRepository.findRatingById(id).orElseThrow(() ->
                new RatingNotFoundException("Rating not found!")
        );
        ratingRepository.deleteById(id);
    }
}
