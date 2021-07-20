package com.cseiu.passnet.saga.usersaga.flow.produce.core.handler;

import com.cseiu.passnet.saga.usersaga.common.models.DomainService;
import com.cseiu.passnet.saga.usersaga.common.models.DomainServiceNames;
import com.cseiu.passnet.saga.usersaga.common.models.SagaOrchestrator;
import com.cseiu.passnet.saga.usersaga.common.services.AvroEventConverter;
import com.cseiu.passnet.saga.usersaga.common.services.SagaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import proto.ProduceEvent;

import java.util.List;

@Component(value = "user-registered.event.producer")
public class UserRegisteredEventProducer implements IMessageProducer<ProduceEvent.UserRegisteredEvent>{
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final AvroEventConverter avroEventConverter;
    private final SagaStoreService sagaStoreService;

    @Value("${config.messaging.topics.user-registered-event}")
    private String topic;

    @Autowired
    public UserRegisteredEventProducer(KafkaTemplate<String, Object> kafkaTemplate, AvroEventConverter avroEventConverter, SagaStoreService sagaStoreService) {
        this.kafkaTemplate = kafkaTemplate;
        this.avroEventConverter = avroEventConverter;
        this.sagaStoreService = sagaStoreService;
    }

    @Override
    public void send(ProduceEvent.UserRegisteredEvent event) {
        storeSaga(event.getEventId());
        var avroEvent = avroEventConverter.build(event);
        kafkaTemplate.send(topic, avroEvent);
    }

    private void storeSaga(String eventId) {
        SagaOrchestrator orchestrator = SagaOrchestrator.builder()
           .eventId(eventId)
           .domainServices(List.of(
              new DomainService(DomainServiceNames.PROFILE_SERVICE),
              new DomainService(DomainServiceNames.ORGANIZER_SERVICE)
           ))
           .build();
        this.sagaStoreService.storeSaga(orchestrator);
    }
}
