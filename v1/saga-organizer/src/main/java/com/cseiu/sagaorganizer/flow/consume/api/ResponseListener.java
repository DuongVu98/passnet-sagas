package com.cseiu.sagaorganizer.flow.consume.api;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.sagaorganizer.flow.consume.core.executor.ConsumingExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[ResponseListener]")
public class ResponseListener {

    @Autowired
    ConsumingExecutor consumingExecutor;

    @KafkaListener(topics = "${config.messaging.topics.success-response}")
    public void listen(SuccessResponse response) {
        log.info("about to consume success response message for event: [{}]", response.getEventId());
    }

    @KafkaListener(topics = "${config.messaging.topics.failure-response}")
    public void listen(FailureResponse response) {
        log.info("about to consume failure response message for event: [{}]", response.getEventId());
        consumingExecutor.consume(response);
    }
}
