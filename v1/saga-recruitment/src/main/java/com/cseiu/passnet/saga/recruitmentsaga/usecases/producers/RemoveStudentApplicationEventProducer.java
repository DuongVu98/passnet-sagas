package com.cseiu.passnet.saga.recruitmentsaga.usecases.producers;

import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.AvroEventConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RemoveStudentApplicationEventProducer implements IMessageProducer<ProduceEvents.RemoveStudentApplicationEvent> {

    private final KafkaTemplate<String, RemoveStudentApplicationEventAvro> kafkaTemplate;
    private final AvroEventConverter avroEventConverter;

    @Value("${spring.kafka.producer.topics.remove-student-application-event}")
    private String topic;

    @Autowired
    public RemoveStudentApplicationEventProducer(@Qualifier("remove-student-application") KafkaTemplate<String, RemoveStudentApplicationEventAvro> kafkaTemplate, AvroEventConverter avroEventConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.avroEventConverter = avroEventConverter;
    }

    @Override
    public void send(ProduceEvents.RemoveStudentApplicationEvent removeStudentApplicationEvent) {
        RemoveStudentApplicationEventAvro event = avroEventConverter.buildRemoveStudentApplicationEventAvro(removeStudentApplicationEvent);
        kafkaTemplate.send(topic, event);
    }
}
