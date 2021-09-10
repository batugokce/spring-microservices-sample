package dev.batugokce.customerservice.customer.controller;

import dev.batugokce.customerservice.customer.entity.Customer;
import dev.batugokce.customerservice.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

}
