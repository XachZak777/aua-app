package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @ColumnDefault("nextval('reservations_reservation_id_seq'::regclass)")
    @Column(name = "reservation_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screening_id")
    private Screening screening;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Column(name = "reservation_time", nullable = false)
    private Instant reservationTime;

    @Column(name = "status", columnDefinition = "reservation_status_type not null")
    private Object status;

    @Column(name = "payment_status", columnDefinition = "payment_status_type not null")
    private Object paymentStatus;
}