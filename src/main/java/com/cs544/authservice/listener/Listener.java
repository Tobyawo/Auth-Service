package com.cs544.authservice.listener;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class Listener {

    @KafkaListener(topics = "login_topic", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("::::::::::::::::::::::Received message: " + message);
    }
}
