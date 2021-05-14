package com.cseiu.passnet.saga.recruitmentsaga.usecases.producers;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.domain.models.DomainService;
import com.cseiu.passnet.saga.recruitmentsaga.domain.models.DomainServiceNames;
import com.cseiu.passnet.saga.recruitmentsaga.domain.models.SagaOrchestrator;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.AvroEventConverter;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.SagaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "accept-student-application.event.producer")
public class AcceptStudentApplicationEventProducer implements IMessageProducer<ProduceEvents.AcceptStudentApplicationEvent>{
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final AvroEventConverter avroEventConverter;
    private final SagaStoreService sagaStoreService;

    @Value("${spring.kafka.topics.produce.accept-student-application-event}")
    private String topic;

    @Autowired
    public AcceptStudentApplicationEventProducer(KafkaTemplate<String, Object> kafkaTemplate, AvroEventConverter avroEventConverter, SagaStoreService sagaStoreService) {
        this.kafkaTemplate = kafkaTemplate;
        this.avroEventConverter = avroEventConverter;
        this.sagaStoreService = sagaStoreService;
    }

    @Override
    public void send(ProduceEvents.AcceptStudentApplicationEvent acceptStudentApplicationEvent) {
        this.storeSaga(acceptStudentApplicationEvent.getEventId());
        AcceptStudentApplicationEventAvro event = avroEventConverter.buildAcceptStudentApplicationEventAvro(acceptStudentApplicationEvent);
        kafkaTemplate.send(topic, event);
    }

    private void storeSaga(String eventId) {
        SagaOrchestrator orchestrator = SagaOrchestrator.builder()
           .eventId(eventId)
           .domainServices(List.of(
              new DomainService(DomainServiceNames.CLASSROOM_SERVICE)
           ))
           .build();
        this.sagaStoreService.storeSaga(orchestrator);
    }

}
