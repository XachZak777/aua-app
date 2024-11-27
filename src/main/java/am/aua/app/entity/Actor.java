package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actors_id_gen")
    @SequenceGenerator(name = "actors_id_gen", sequenceName = "actors_actor_id_seq", allocationSize = 1)
    @Column(name = "actor_id", nullable = false)
    private Integer id;

    @Column(name = "actor_first_name", nullable = false, length = 254)
    private String actorFirstName;

    @Column(name = "actor_last_name", nullable = false, length = 254)
    private String actorLastName;

    @Column(name = "biography", nullable = false, length = Integer.MAX_VALUE)
    private String biography;

}