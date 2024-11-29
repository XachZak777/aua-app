package am.aua.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import am.aua.app.entity.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerById (Integer customerId);
    Customer save(Customer customer);
}