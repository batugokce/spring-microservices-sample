package dev.batugokce.customerservice.customer.service;

import dev.batugokce.customerservice.asynccall.event.CustomerCreationEvent;
import dev.batugokce.customerservice.asynccall.service.PublishService;
import dev.batugokce.customerservice.customer.entity.Customer;
import dev.batugokce.customerservice.customer.exception.IncorrectPasswordException;
import dev.batugokce.customerservice.customer.exception.UserNotFoundException;
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

    @Transactional(readOnly = true)
    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public void changePassword(String username, String oldPassword, String newPassword) {
        Customer customer = customerRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        if (!customer.checkPassword(oldPassword)) {
            throw new IncorrectPasswordException();
        }
        customerRepository.updatePassword(newPassword, username);
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
