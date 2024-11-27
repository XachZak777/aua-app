package am.aua.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class MovieActorId implements java.io.Serializable {
    private static final long serialVersionUID = 6340939482055761266L;
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "actor_id", nullable = false)
    private Integer actorId;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieActorId entity = (MovieActorId) o;
        return Objects.equals(this.actorId, entity.actorId) &&
                Objects.equals(this.movieId, entity.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, movieId);
    }

}