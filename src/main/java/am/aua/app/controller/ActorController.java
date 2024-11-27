package am.aua.app.controller;

import am.aua.app.dto.ActorRequest;
import am.aua.app.entity.Actor;
import am.aua.app.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Actor>> findAllActors(){
       return ResponseEntity.ok(actorService.findAllActors());
    }

    @PostMapping("/create")
    public ResponseEntity<Actor> createActor(@RequestBody ActorRequest actorRequest){
        return ResponseEntity.ok(actorService.createActor(actorRequest));
    }

}
