package com.cseiu.passnet.saga.classroomsaga.adapters.messaging;

import com.cse.iu.passnet.saga.avro.*;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j(topic = "[KafkaEventConsumer]")
public class KafkaEventConsumer {

    @KafkaListener(topics = "post-new-job-event")
    public void listenPostNewJobEvent(@Payload PostNewJobEventAvro event){
        log.info("log record --> {}", event);
    }

    @KafkaListener(topics = "accept-student-application-event")
    public void listenAcceptStudentApplicationEvent(@Payload AcceptStudentApplicationEventAvro event){
        log.debug("log record --> {}", event);
    }

    @KafkaListener(topics = "remove-student-application-event")
    public void listenRemoveStudentApplicationEvent(@Payload RemoveStudentApplicationEventAvro event){
        log.debug("log record --> {}", event);
    }

    @KafkaListener(topics = "delete-job-event")
    public void listenDeleteJobEvent(@Payload DeleteJobEventAvro event){
        log.debug("log record --> {}", event);
    }
}
