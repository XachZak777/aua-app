package am.aua.app.controller;

import am.aua.app.dto.CustomerRequest;
import am.aua.app.entity.Customer;
import am.aua.app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> findAllCustomers () {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById (@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @PostMapping()
    public ResponseEntity<Customer> createCustomer (@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }

    public ResponseEntity<String> deleteAuthor (@PathVariable("id") Integer id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok(String.format("Author with %s id is not found", id));
    }
}