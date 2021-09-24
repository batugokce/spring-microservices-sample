package dev.batugokce.customerservice.asynccall.service;

import dev.batugokce.customerservice.asynccall.enums.Topics;
import dev.batugokce.customerservice.asynccall.event.CustomerCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishService {

    private final KafkaTemplate<Long, CustomerCreationEvent> kafkaTemplate;

    public void sendMessage(CustomerCreationEvent customerCreationEvent) {
        kafkaTemplate.send(Topics.NEW_CUSTOMER_CREATED.name(), customerCreationEvent.getCustomerId(), customerCreationEvent);
    }

}
