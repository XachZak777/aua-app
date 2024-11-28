package am.aua.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;
import java.util.Objects;

@Embeddable
public class MovieAuthorId implements java.io.Serializable {
    private static final long serialVersionUID = -5658961862015760517L;
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "author_id", nullable = false)
    private Integer authorId;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieAuthorId entity = (MovieAuthorId) o;
        return Objects.equals(this.movieId, entity.movieId) &&
                Objects.equals(this.authorId, entity.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, authorId);
    }

}