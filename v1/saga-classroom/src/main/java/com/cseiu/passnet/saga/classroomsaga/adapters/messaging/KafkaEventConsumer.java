package com.cseiu.passnet.saga.classroomsaga.adapters.messaging;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.DeleteJobEventAvro;
import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[KafkaEventConsumer]")
public class KafkaEventConsumer {

    @KafkaListener(topics = "post-new-job-event", containerFactory = "postNewJobEventContainerFactory")
    public void listenPostNewJobEvent(@Payload PostNewJobEventAvro event){
        log.info("log from Consumer");
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
