package am.aua.app.repository;

import am.aua.app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Optional<Payment> findPaymentById (Integer id);
    Payment save(Payment payment);
}
