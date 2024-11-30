package am.aua.app.service;

import am.aua.app.dto.PaymentRequest;
import am.aua.app.entity.Notification;
import am.aua.app.entity.Payment;
import am.aua.app.exception.PaymentNotFoundException;
import am.aua.app.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public List<Payment> findAllPayments () {
        return paymentRepository.findAll();
    }

    public Payment findPaymentById (Integer paymentId) {
        return paymentRepository.findPaymentById(paymentId).orElseThrow(() ->
                new PaymentNotFoundException("Payment not found!")
        );
    }

    public Payment createPayment (PaymentRequest paymentRequest) {
        var savedPayment = paymentRepository.save(
                Payment.builder()
                        .reservation(paymentRequest.getReservation())
                        .amount(paymentRequest.getAmount())
                        .paymentMethod(paymentRequest.getPaymentMethod())
                        .paymentDate(paymentRequest.getPaymentDate())
                        .refundStatus(paymentRequest.getRefundStatus())
                        .build()
        );
        return savedPayment;
    }

    public void deletePaymentById (Integer id) {
        Payment payment = paymentRepository.findPaymentById(id).orElseThrow(() ->
                new PaymentNotFoundException("Payment not found!")
        );
        paymentRepository.deleteById(id);
    }
}
