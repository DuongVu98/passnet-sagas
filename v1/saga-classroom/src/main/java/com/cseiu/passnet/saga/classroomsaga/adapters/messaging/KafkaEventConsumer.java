package com.cseiu.passnet.saga.classroomsaga.adapters.messaging;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.DeleteJobEventAvro;
import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[KafkaEventConsumer]")
public class KafkaEventConsumer {

    @KafkaListener(topics = "post-new-job-event")
    public void listenPostNewJobEvent(@Payload PostNewJobEventAvro event){
        log.debug("log record --> {}", event);
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
