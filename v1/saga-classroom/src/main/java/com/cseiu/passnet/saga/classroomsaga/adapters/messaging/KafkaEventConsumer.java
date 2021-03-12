package com.cseiu.passnet.saga.classroomsaga.adapters.messaging;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[KafkaEventConsumer]")
public class KafkaEventConsumer {

    @KafkaListener(topics = "topic-name")
    public void listenSomeEvent(ConsumerRecord<String, String> record){
        log.debug("log record --> {}", record.value());
    }
}
