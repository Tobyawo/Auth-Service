package com.cs544.authservice.producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginEventProducer {

    @Autowired
    private KafkaTemplate<String, LoginEvent> kafkaTemplate;



    private final String topic = "login_topic";

    public void sendLoginEvent(LoginEvent event) {

        log.info("******Sending login event: {}", event);
        kafkaTemplate.send(topic, event);
    }
}

