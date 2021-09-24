package dev.batugokce.customerservice.customer.service;

import dev.batugokce.customerservice.asynccall.event.CustomerCreationEvent;
import dev.batugokce.customerservice.asynccall.service.PublishService;
import dev.batugokce.customerservice.customer.entity.Customer;
import dev.batugokce.customerservice.customer.exception.UsernameAlreadyUsedException;
import dev.batugokce.customerservice.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PublishService publishService;

    @Transactional
    public void createCustomer(Customer customer) {
        checkUsernameUniqueness(customer.getUsername());
        Customer customerDB = customerRepository.save(customer);
        callPublishService(customerDB);
    }

    private void checkUsernameUniqueness(String username) {
        if (customerRepository.existsByUsername(username)) {
            throw new UsernameAlreadyUsedException(String.format("Username:%s is already used.", username));
        }
    }

    private void callPublishService(Customer customer) {
        CustomerCreationEvent customerCreationEvent = new CustomerCreationEvent(customer);
        publishService.sendMessage(customerCreationEvent);
    }

}
