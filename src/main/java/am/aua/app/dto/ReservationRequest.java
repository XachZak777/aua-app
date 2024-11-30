package am.aua.app.dto;

import am.aua.app.entity.Customer;
import am.aua.app.entity.Screening;
import am.aua.app.entity.enums.PaymentStatusType;
import am.aua.app.entity.enums.ReservationStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    private Screening screening;
    private Customer customer;
    private Integer seatNumber;
    private Instant reservationTime;
    private ReservationStatusType status;
    private PaymentStatusType paymentStatus;

}
