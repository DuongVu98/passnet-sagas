package com.cseiu.passnet.sagaprofile.flow.consume.api;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[ResponseListener]")
public class ResponseListener {

    @KafkaListener(topics = "${config.messaging.topics.success-response}")
    public void listen(SuccessResponse response) {

    }

    @KafkaListener(topics = "${config.messaging.topics.failure-response}")
    public void listen(FailureResponse response){

    }
}
