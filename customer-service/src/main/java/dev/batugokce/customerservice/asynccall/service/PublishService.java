package dev.batugokce.customerservice.asynccall.service;

import dev.batugokce.customerservice.asynccall.enums.Topics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishService {

    private final KafkaTemplate<Long, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(Topics.NEW_CUSTOMER_CREATED.name(), 1L, message);
    }

}
