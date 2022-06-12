package dev.batugokce.customerservice.asynccall.producer;

import dev.batugokce.customerservice.asynccall.enums.Topics;
import dev.batugokce.customerservice.asynccall.event.CustomerCreationEvent;
import dev.batugokce.customerservice.customer.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerCreationProducer {

    private final KafkaTemplate<Long, CustomerCreationEvent> kafkaTemplate;

    public void publishMessage(Customer createdCustomer) {
        var event = CustomerCreationEvent.builder()
                .customerId(createdCustomer.getId())
                .build();

        kafkaTemplate.send(Topics.NEW_CUSTOMER_CREATED.name(), event.getCustomerId(), event);
    }

}
