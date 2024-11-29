package am.aua.app.dto;

import am.aua.app.entity.enums.GenreType;
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
public class MovieRequest {

    private String title;
    private String description;
    private LocalTime duration;
    private LocalDate releaseDate;
    private BigDecimal rating;
    private GenreType genre;

}
