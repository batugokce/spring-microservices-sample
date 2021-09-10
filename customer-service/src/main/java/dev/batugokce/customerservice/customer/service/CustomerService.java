package dev.batugokce.customerservice.customer.service;

import dev.batugokce.customerservice.customer.entity.Customer;
import dev.batugokce.customerservice.customer.exception.UsernameAlreadyUsedException;
import dev.batugokce.customerservice.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        checkUsernameUniqueness(customer.getUsername());
        customerRepository.save(customer);
    }

    private void checkUsernameUniqueness(String username) {
        if (customerRepository.existsByUsername(username)) {
            throw new UsernameAlreadyUsedException(String.format("Username:%s is already used.", username));
        }
    }
}
