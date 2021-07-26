package com.cseiu.sagaorganizer.flow.consume.core.handler;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.organizersaga.ConsumeEvents;
import com.cseiu.sagaorganizer.common.models.DomainServiceNames;
import com.cseiu.sagaorganizer.common.services.EventStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServiceResponseHandler {

    private static String SERVICE_NAME = DomainServiceNames.ORGANIZER_SERVICE.name();
    private final EventStoreService eventStoreService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${config.constants.success-message}")
    private String SUCCESS_MESSAGE;
    @Value("${config.constants.failure-message}")
    private String FAILURE_MESSAGE;

    @Value("${config.messaging.topics.success-response}")
    private String successResponseTopic;
    @Value("${config.messaging.topics.failure-response}")
    private String failureResponseTopic;

    @Autowired
    public ServiceResponseHandler(EventStoreService eventStoreService, KafkaTemplate<String, Object> kafkaTemplate) {
        this.eventStoreService = eventStoreService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void handle(ConsumeEvents.ServiceResponseProtobuf response, String eventId) {
        if (response.getMessage().equals(SUCCESS_MESSAGE)) {
            this.eventStoreService.storeEvent(eventId);

            var successResponse = SuccessResponse.newBuilder().setServiceName(SERVICE_NAME).setEventId(eventId).build();
            this.kafkaTemplate.send(successResponseTopic, successResponse);
        } else if (response.getMessage().equals(FAILURE_MESSAGE)) {
            var failureResponse = FailureResponse.newBuilder().setServiceName(SERVICE_NAME).setEventId(eventId).build();
            this.kafkaTemplate.send(failureResponseTopic, failureResponse);
        }
    }
}