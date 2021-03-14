package com.cseiu.passnet.saga.classroomsaga.config;

import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[OtherKafkaConsumer]")
//@KafkaListener(topics = "post-new-job-event")
public class OtherKafkaConsumer {

//    @KafkaHandler
//    public void listenPostNewJobEvent(PostNewJobEventAvro event){
//        log.debug("log record --> {}", event.getJobId());
//    }
}
