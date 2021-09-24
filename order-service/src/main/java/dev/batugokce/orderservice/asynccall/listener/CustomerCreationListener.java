package dev.batugokce.orderservice.asynccall.listener;

import dev.batugokce.orderservice.asynccall.constants.Topics;
import dev.batugokce.orderservice.asynccall.event.CustomerCreationEvent;
import dev.batugokce.orderservice.asynccall.mapper.CustomerEventMapper;
import dev.batugokce.orderservice.customer.entity.Customer;
import dev.batugokce.orderservice.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCreationListener {

    private final CustomerService customerService;
    private final CustomerEventMapper customerMapper;

    @KafkaListener(topics = Topics.NEW_CUSTOMER_CREATED)
    public void listen(CustomerCreationEvent event) {
        Customer customer = customerMapper.toCustomer(event);
        customerService.save(customer);
    }

}
