package com.cseiu.passnet.saga.classroomsaga.flow.consume.core.handler;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import com.cseiu.passnet.saga.classroomsaga.common.models.DomainServiceNames;
import com.cseiu.passnet.saga.classroomsaga.common.services.EventStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServiceResponseHandler {

    private final EventStoreService eventStoreService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${constants.success-message}")
    private String SUCCESS_MESSAGE;
    @Value("${constants.failure-message}")
    private String FAILURE_MESSAGE;

    @Value("${spring.kafka.topics.success-response}")
    private String successResponseTopic;
    @Value("${spring.kafka.topics.failure-response}")
    private String failureResponseTopic;

    @Autowired
    public ServiceResponseHandler(EventStoreService eventStoreService, KafkaTemplate<String, Object> kafkaTemplate) {
        this.eventStoreService = eventStoreService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void handle(ConsumeEvents.ServiceResponse response, String eventId) {
        if (response.getMessage().equals(SUCCESS_MESSAGE)) {
            this.eventStoreService.storeEvent(eventId);

            SuccessResponse successResponse = SuccessResponse.newBuilder().setServiceName(DomainServiceNames.CLASSROOM_SERVICE.name()).setEventId(eventId).build();
            this.kafkaTemplate.send(successResponseTopic, successResponse);
        } else if (response.getMessage().equals(FAILURE_MESSAGE)) {
            FailureResponse failureResponse = FailureResponse.newBuilder().setServiceName(DomainServiceNames.CLASSROOM_SERVICE.name()).setEventId(eventId).build();
            this.kafkaTemplate.send(failureResponseTopic, failureResponse);
        }
    }
}