package com.cseiu.passnet.saga.authenticationsaga.api.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[Consumer]")
public class Consumer {

    @KafkaListener(topics = "test", groupId = "passnet-auth-saga")
    public void listenFromEvent(@Payload String message){
        log.info("message from server: {}", message);
    }
}
