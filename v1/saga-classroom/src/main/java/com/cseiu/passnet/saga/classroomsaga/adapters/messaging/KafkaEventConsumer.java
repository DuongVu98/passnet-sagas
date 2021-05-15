package com.cseiu.passnet.saga.classroomsaga.adapters.messaging;

import com.cse.iu.passnet.saga.avro.*;

import com.cseiu.passnet.saga.classroomsaga.usecases.consumers.IMessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j(topic = "[KafkaEventConsumer]")
public class KafkaEventConsumer {

    @Autowired
    @Qualifier("post-new-job-event-consumer")
    private IMessageConsumer<PostNewJobEventAvro> postNewJobEventConsumer;

    @Autowired
    @Qualifier("accept-student-application-event-consumer")
    private IMessageConsumer<AcceptStudentApplicationEventAvro> acceptStudentApplicationEventConsumer;

    @Autowired
    @Qualifier("remove-student-application-event-consumer")
    private IMessageConsumer<RemoveStudentApplicationEventAvro> removeStudentApplicationEventConsumer;

    @Autowired
    @Qualifier("delete-job-event-consumer")
    private IMessageConsumer<DeleteJobEventAvro> deleteJobEventConsumer;

    @KafkaListener(topics = "${spring.kafka.topics.post-new-job-event}")
    public void listenPostNewJobEvent(@Payload PostNewJobEventAvro event){
        log.info("log record --> {}", event);
        postNewJobEventConsumer.consume(event);
    }

    @KafkaListener(topics = "${spring.kafka.topics.accept-student-application-event}")
    public void listenAcceptStudentApplicationEvent(@Payload AcceptStudentApplicationEventAvro event){
        log.debug("log record --> {}", event);
        acceptStudentApplicationEventConsumer.consume(event);
    }

    @KafkaListener(topics = "${spring.kafka.topics.remove-student-application-event}")
    public void listenRemoveStudentApplicationEvent(@Payload RemoveStudentApplicationEventAvro event){
        log.debug("log record --> {}", event);
        removeStudentApplicationEventConsumer.consume(event);
    }

    @KafkaListener(topics = "${spring.kafka.topics.delete-job-event}")
    public void listenDeleteJobEvent(@Payload DeleteJobEventAvro event){
        log.debug("log record --> {}", event);
        deleteJobEventConsumer.consume(event);
    }
}
