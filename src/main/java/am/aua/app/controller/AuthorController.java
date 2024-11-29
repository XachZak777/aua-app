package am.aua.app.controller;

import am.aua.app.dto.AuthorRequest;
import am.aua.app.entity.Author;
import am.aua.app.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<List<Author>> findAllAuthors() {
        return ResponseEntity.ok(authorService.findAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById (@PathVariable Integer id) {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.ok(authorService.createAuthor(authorRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor (@PathVariable("id") Integer id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok(String.format("Author with %s id is not found", id));
    }
}