package am.aua.app.service;

import am.aua.app.dto.CustomerRequest;
import am.aua.app.entity.Customer;
import am.aua.app.exception.CustomerNotFoundException;
import am.aua.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAllCustomers () {
        return customerRepository.findAll();
    }

    public Customer createCustomer (CustomerRequest customerRequest) {
        var savedCustomer = customerRepository.save(
                Customer.builder()
                        .user(customerRequest.getUser())
                        .membershipLevel(customerRequest.getMembershipLevel())
                        .preferences(customerRequest.getPreferences())
                        .build()
        );
        return savedCustomer;
    }

    public Customer findCustomerById (Integer customerId) {
        return customerRepository.findCustomerById(customerId).orElseThrow(() ->
                new CustomerNotFoundException("Customer not found!")
        );
    }

    public void deleteCustomerById (Integer customerId) {
        Customer customer = customerRepository.findCustomerById(customerId).orElseThrow(() ->
                new CustomerNotFoundException("Customer not found!")
        );
        customerRepository.deleteById(customerId);
    }
}