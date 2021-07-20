package com.cseiu.sagaorganizer.flow.consume.api;

import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import com.cseiu.sagaorganizer.flow.consume.core.executor.ConsumingExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[EventListener]")
public class EventListener {

    private final ConsumingExecutor consumingExecutor;

    @Autowired
    public EventListener(ConsumingExecutor consumingExecutor) {
        this.consumingExecutor = consumingExecutor;
    }

    @KafkaListener(topics = "${config.messaging.topics.user-registered-event}")
    public void listen(@Payload UserRegisteredEventAvro event) {
        log.info("about to consume UserRegisteredEvent: {}", event.getEventId());

        consumingExecutor.consume(event);
    }
}
