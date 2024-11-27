package am.aua.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "movie_hall")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieHall {
    @Id
    @ColumnDefault("nextval('movie_hall_hall_id_seq'::regclass)")
    @Column(name = "hall_id", nullable = false)
    private Integer id;

    @Column(name = "hall_name", nullable = false, length = 254)
    private String hallName;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "hall_status", columnDefinition = "hall_status_type not null")
    private Object hallStatus;

    @Column(name = "features", columnDefinition = "hall_features_type not null")
    private Object features;

}