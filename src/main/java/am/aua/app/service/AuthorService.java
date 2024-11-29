package am.aua.app.service;

import am.aua.app.dto.AuthorRequest;
import am.aua.app.entity.Author;
import am.aua.app.exception.AuthorNotFoundException;
import am.aua.app.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAllAuthors () {
        return authorRepository.findAll();
    }

    public Author createAuthor(AuthorRequest authorRequest) {
        var savedAuthor = authorRepository.save(
                Author.builder()
                        .authorFirstName(authorRequest.getAuthorFirstName())
                        .authorLastName(authorRequest.getAuthorLastName())
                        .authorRole(authorRequest.getAuthorRole())
                        .biography(authorRequest.getBiography())
                        .build()
        );
        return savedAuthor;
    }

    public Author findAuthorById(Integer id) {
        return  authorRepository.findAuthorById(id).orElseThrow(() ->
                new AuthorNotFoundException("No author found")
        );
    }

    public void deleteAuthorById (Integer id) {
        Author author = authorRepository.findAuthorById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found!"));
        authorRepository.deleteById(id);
    }
}