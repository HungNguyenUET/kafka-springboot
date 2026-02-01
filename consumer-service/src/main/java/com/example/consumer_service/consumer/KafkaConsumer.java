package com.example.consumer_service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {
    @KafkaListener(
        topics = "message",
        groupId = "group-2"
    )
    public void listen(String message) {
        log.info("Received message: {}", message);
    }
}
