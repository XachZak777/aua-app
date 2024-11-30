package am.aua.app.dto;

import am.aua.app.entity.Reservation;
import am.aua.app.entity.enums.PaymentMethod;
import am.aua.app.entity.enums.RefundStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private Reservation reservation;
    private Integer amount;
    private Instant paymentDate;
    private PaymentMethod paymentMethod;
    private RefundStatus refundStatus;

}
