package com.cseiu.passnet.saga.recruitmentsaga.flow.consume.api;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[KafkaResponseConsumer]")
public class KafkaResponseListener {

    @KafkaListener(topics = "${spring.kafka.topics.success-response}")
    public void onResponse(@Payload SuccessResponse successResponse) {
        log.info("event [{}] from service [{}] success", successResponse.getEventId(), successResponse.getServiceName());
    }

    @KafkaListener(topics = "${spring.kafka.topics.failure-response}")
    public void onResponse(@Payload FailureResponse failureResponse) {
        log.info("event [{}] from service [{}] success", failureResponse.getEventId(), failureResponse.getServiceName());
    }
}
