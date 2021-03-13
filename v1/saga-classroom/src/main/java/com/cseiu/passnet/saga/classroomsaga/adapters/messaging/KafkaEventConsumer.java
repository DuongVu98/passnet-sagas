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

    @KafkaListener(topics = "topic-name", containerFactory = "postNewJobEventContainerFactory")
    public void listenPostNewJobEvent(@Payload PostNewJobEventAvro event){
        log.debug("log record --> {}", event);
    }

    @KafkaListener(topics = "topic-name", containerFactory = "acceptStudentApplicationEventContainerFactory")
    public void listenAcceptStudentApplicationEvent(@Payload AcceptStudentApplicationEventAvro event){
        log.debug("log record --> {}", event);
    }

    @KafkaListener(topics = "topic-name", containerFactory = "removeStudentApplicationEventContainerFactory")
    public void listenRemoveStudentApplicationEvent(@Payload RemoveStudentApplicationEventAvro event){
        log.debug("log record --> {}", event);
    }

    @KafkaListener(topics = "topic-name", containerFactory = "deleteJobEventContainerFactory")
    public void listenDeleteJobEvent(@Payload DeleteJobEventAvro event){
        log.debug("log record --> {}", event);
    }
}
