package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    @Id
    @ColumnDefault("nextval('staff_staff_id_seq'::regclass)")
    @Column(name = "staff_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;
    @Column(name = "permissions", nullable = false, length = Integer.MAX_VALUE)
    private String permissions;

    @Column(name = "staff_position", columnDefinition = "staff_position_type not null")
    private Object staffPosition;
}