package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    @Id
    @ColumnDefault("nextval('ratings_rating_id_seq'::regclass)")
    @Column(name = "rating_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "rating_value", nullable = false, precision = 3, scale = 1)
    private BigDecimal ratingValue;

    @Column(name = "review", nullable = false, length = Integer.MAX_VALUE)
    private String review;

    @Column(name = "rating_date", nullable = false)
    private LocalDate ratingDate;

    @Column(name = "rating_time", nullable = false)
    private LocalTime ratingTime;
}