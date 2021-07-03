package com.cseiu.passnet.saga.recruitmentsaga.flow.consume.api;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.executor.ConsumingExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[KafkaResponseListener]")
public class KafkaResponseListener {

    private final ConsumingExecutor consumingExecutor;

    @Autowired
    public KafkaResponseListener(ConsumingExecutor consumingExecutor) {
        this.consumingExecutor = consumingExecutor;
    }

    @KafkaListener(topics = "${config.messaging.topics.success-response}")
    public void onResponse(@Payload SuccessResponse successResponse) {
        log.info("event [{}] from service [{}] success", successResponse.getEventId(), successResponse.getServiceName());
        this.consumingExecutor.consume(successResponse);
    }

    @KafkaListener(topics = "${config.messaging.topics.failure-response}")
    public void onResponse(@Payload FailureResponse failureResponse) {
        log.info("event [{}] from service [{}] failure", failureResponse.getEventId(), failureResponse.getServiceName());
        this.consumingExecutor.consume(failureResponse);
    }
}
