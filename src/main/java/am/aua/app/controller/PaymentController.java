package am.aua.app.controller;

import am.aua.app.dto.PaymentRequest;
import am.aua.app.entity.Payment;
import am.aua.app.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> findAllPayment() {
        return ResponseEntity.ok(paymentService.findAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findPaymentById(Integer id) {
        return ResponseEntity.ok(paymentService.findPaymentById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") Integer id) {
        paymentService.deletePaymentById(id);
        return ResponseEntity.ok(String.format("Payment with %s id is not found", id));
    }
}