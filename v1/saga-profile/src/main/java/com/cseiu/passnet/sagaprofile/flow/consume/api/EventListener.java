package com.cseiu.passnet.sagaprofile.flow.consume.api;

import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[EventListener]")
public class EventListener {

    @KafkaListener(topics = "${config.messaging.topics.user-registered-event}")
    public void listen(@Payload UserRegisteredEventAvro event){
        log.info("about to consume UserRegisteredEvent: {}", event.getEventId());
    }
}
