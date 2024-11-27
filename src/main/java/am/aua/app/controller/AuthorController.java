package am.aua.app.controller;

import am.aua.app.dto.AuthorRequest;
import am.aua.app.entity.Author;
import am.aua.app.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/findAllAuthors")
    public ResponseEntity<List<Author>> findAllAuthors() {
        return ResponseEntity.ok(authorService.findAllAuthors());
    }

    @PostMapping("/createAuthor")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.ok(authorService.createAuthor(authorRequest));
    }
}