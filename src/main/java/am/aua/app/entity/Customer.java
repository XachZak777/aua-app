package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @ColumnDefault("nextval('customers_customer_id_seq'::regclass)")
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "preferences", nullable = false, length = Integer.MAX_VALUE)
    private String preferences;

    @Column(name = "membership_level", columnDefinition = "membership_type not null")
    private Object membershipLevel;

}