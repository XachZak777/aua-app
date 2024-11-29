package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieAuthor {
    @EmbeddedId
    private MovieAuthorId id;

    @MapsId("movieId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @MapsId("authorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

}