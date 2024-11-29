package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "screening")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screening {
    @Id
    @ColumnDefault("nextval('screening_screening_id_seq'::regclass)")
    @Column(name = "screening_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    private MovieHall hall;

    @Column(name = "screening_time", nullable = false)
    private Instant screeningTime;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "screening_status", columnDefinition = "screening_status_type not null")
    private Object screeningStatus;
}