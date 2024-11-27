package am.aua.app.service;

import am.aua.app.dto.ActorRequest;
import am.aua.app.entity.Actor;
import am.aua.app.exception.ActorException;
import am.aua.app.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public List<Actor> findAllActors () {
        return actorRepository.findAll();
    }

    public Actor getActorById (Integer actorId){
        return actorRepository.findActorById(actorId).orElseThrow(() ->
                new ActorException("Actor not found")
        );
    }

    public Actor createActor (ActorRequest actorRequest) {
        var savedActor = actorRepository.save(
                Actor.builder()
                        .actorFirstName(actorRequest.getActorFirstName())
                        .actorLastName(actorRequest.getActorLastName())
                        .biography(actorRequest.getBiography())
                        .build()
        );
        return savedActor;
    }
}