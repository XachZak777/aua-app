package am.aua.app.entity;

import am.aua.app.entity.enums.PaymentMethod;
import am.aua.app.entity.enums.RefundStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import java.time.Instant;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @ColumnDefault("nextval('payments_payment_id_seq'::regclass)")
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "payment_date", nullable = false)
    private Instant paymentDate;

    @Column(name = "payment_method", columnDefinition = "payment_method_type not null")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "refund_status", columnDefinition = "refund_status_type not null")
    @Enumerated(EnumType.STRING)
    private RefundStatus refundStatus;

}