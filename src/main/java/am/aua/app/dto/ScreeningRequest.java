package am.aua.app.dto;

import am.aua.app.entity.Movie;
import am.aua.app.entity.MovieHall;
import am.aua.app.entity.enums.ScreeningStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningRequest {

    private Movie movie;
    private MovieHall hall;
    private Instant screeningTime;
    private Integer price;
    private ScreeningStatusType screeningStatus;

}
