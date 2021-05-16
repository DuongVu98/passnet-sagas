package com.cseiu.passnet.saga.classroomsaga.flow.consume.api;

import com.cse.iu.passnet.saga.avro.*;

import com.cseiu.passnet.saga.classroomsaga.flow.consume.core.executor.ConsumingExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j(topic = "[KafkaEventConsumer]")
public class KafkaEventListener {

    private final ConsumingExecutor consumingExecutor;

    @Autowired
    public KafkaEventListener(ConsumingExecutor consumingExecutor) {
        this.consumingExecutor = consumingExecutor;
    }

    @KafkaListener(topics = "${spring.kafka.topics.accept-student-application-event}")
    public void listenAcceptStudentApplicationEvent(@Payload AcceptStudentApplicationEventAvro event){
        log.debug("log record --> {}", event);
        consumingExecutor.consume(event);
    }

    @KafkaListener(topics = "${spring.kafka.topics.remove-student-application-event}")
    public void listenRemoveStudentApplicationEvent(@Payload RemoveStudentApplicationEventAvro event){
        log.debug("log record --> {}", event);
        consumingExecutor.consume(event);
    }
}
