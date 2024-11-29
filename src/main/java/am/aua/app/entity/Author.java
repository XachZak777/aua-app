package am.aua.app.entity;

import am.aua.app.entity.enums.AuthorRoleType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @ColumnDefault("nextval('authors_author_id_seq'::regclass)")
    @Column(name = "author_id", nullable = false)
    private Integer id;

    @Column(name = "author_first_name", nullable = false, length = 254)
    private String authorFirstName;

    @Column(name = "author_last_name", nullable = false, length = 254)
    private String authorLastName;

    @Column(name = "biography", nullable = false, length = Integer.MAX_VALUE)
    private String biography;

    @Column(name = "author_role", columnDefinition = "author_role_type not null")
    @Enumerated(EnumType.STRING)
    private AuthorRoleType authorRole;
}