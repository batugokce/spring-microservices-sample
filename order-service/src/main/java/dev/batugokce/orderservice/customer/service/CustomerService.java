package dev.batugokce.orderservice.customer.service;

import dev.batugokce.orderservice.customer.entity.Customer;
import dev.batugokce.orderservice.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findById(long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

}
