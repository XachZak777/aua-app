package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;

@Entity
@Table(name = "movie_actors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieActor {
    @EmbeddedId
    private MovieActorId id;

    @MapsId("movieId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

}