package com.example.pushlisher_service.controller;

import com.example.pushlisher_service.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MessageController {
    private final KafkaProducer kafkaProducer;

    @PostMapping("/message/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        kafkaProducer.send("message", message);
        return "Message sent!";
    }

}
