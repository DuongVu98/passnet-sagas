package com.cseiu.passnet.saga.recruitmentsaga.usecases.producers;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.AvroEventConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component(value = "accept-student-application-event-producer")
public class AcceptStudentApplicationEventProducer implements IMessageProducer<ProduceEvents.AcceptStudentApplicationEvent>{
    private final KafkaTemplate<String, AcceptStudentApplicationEventAvro> kafkaTemplate;
    private final AvroEventConverter avroEventConverter;

    @Value("${spring.kafka.producer.topics.accept-student-application-event}")
    private String topic;

    public AcceptStudentApplicationEventProducer(@Qualifier("accept-student-application") KafkaTemplate<String, AcceptStudentApplicationEventAvro> kafkaTemplate, AvroEventConverter avroEventConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.avroEventConverter = avroEventConverter;
    }

    @Override
    public void send(ProduceEvents.AcceptStudentApplicationEvent acceptStudentApplicationEvent) {
        AcceptStudentApplicationEventAvro event = avroEventConverter.buildAcceptStudentApplicationEventAvro(acceptStudentApplicationEvent);
        kafkaTemplate.send(topic, event);
    }
}
