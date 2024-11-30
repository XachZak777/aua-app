package am.aua.app.dto;

import am.aua.app.entity.Customer;
import am.aua.app.entity.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingRequest {

    private Movie movie;
    private Customer customer;
    private BigDecimal ratingValue;
    private String review;
    private LocalDate ratingDate;
    private LocalTime ratingTime;

}
