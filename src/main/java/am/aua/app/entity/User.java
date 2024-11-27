package am.aua.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    @ColumnDefault("nextval('users_user_id_seq'::regclass)")
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

    @Column(name = "status", columnDefinition = "status_type not null")
    private Object status;
}