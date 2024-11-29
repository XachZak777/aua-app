package am.aua.app.controller;

import am.aua.app.dto.ActorRequest;
import am.aua.app.entity.Actor;
import am.aua.app.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping("/all")
    public ResponseEntity<List<Actor>> findAllActors () {
       return ResponseEntity.ok(actorService.findAllActors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findActorById (@PathVariable Integer id) {
        return ResponseEntity.ok(actorService.findActorById(id));
    }

    @PostMapping()
    public ResponseEntity<Actor> createActor (@RequestBody ActorRequest actorRequest) {
        return ResponseEntity.ok(actorService.createActor(actorRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActor (@PathVariable("id") Integer id) {
        actorService.deleteActorById(id);
        return ResponseEntity.ok(String.format("Actor with %s id is not found", id));
    }
}