package am.aua.app.entity;

import am.aua.app.entity.enums.HallFeaturesType;
import am.aua.app.entity.enums.HallStatusType;
import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private HallStatusType hallStatus;

    @Column(name = "features", columnDefinition = "hall_features_type not null")
    @Enumerated(EnumType.STRING)
    private HallFeaturesType features;

}