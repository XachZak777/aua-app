package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

}