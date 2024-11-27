package am.aua.app.repository;

import am.aua.app.dto.ActorRequest;
import am.aua.app.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Optional<Actor> findActorById(Integer id);
    Optional<Actor> findByActorFirstName(String actorFirstName);
    Actor save(Actor actor);

}
