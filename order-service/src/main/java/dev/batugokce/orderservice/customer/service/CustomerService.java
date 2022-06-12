package dev.batugokce.orderservice.customer.service;

import dev.batugokce.orderservice.customer.entity.Customer;
import dev.batugokce.orderservice.customer.repository.CustomerRepository;
import dev.batugokce.orderservice.order.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public Customer findById(long customerId) {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }

    @Transactional
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

}
