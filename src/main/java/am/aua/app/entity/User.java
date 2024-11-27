package am.aua.app.entity;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_user_id_seq", allocationSize = 1)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 254)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 254)
    private String lastName;

    @Column(name = "email", nullable = false, length = 254)
    private String email;

    @Column(name = "passkey", nullable = false, length = 254)
    private String passkey;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;


    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;
}