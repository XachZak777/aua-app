package am.aua.app.repository;

import am.aua.app.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findAuthorById (Integer authorId);
    Author save(Author author);
}
