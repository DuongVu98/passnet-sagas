package com.cseiu.passnet.saga.recruitmentsaga.usecases.producers;

import com.cse.iu.passnet.saga.avro.DeleteJobEventAvro;
import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.AvroEventConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component(value = "delete-job.event.producer")
public class DeleteJobEventProducer implements IMessageProducer<ProduceEvents.DeleteJobEvent>{

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final AvroEventConverter avroEventConverter;

    @Value("${spring.kafka.topics.delete-job-event}")
    private String topic;

    @Autowired
    public DeleteJobEventProducer(KafkaTemplate<String, Object> kafkaTemplate, AvroEventConverter avroEventConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.avroEventConverter = avroEventConverter;
    }

    @Override
    public void send(ProduceEvents.DeleteJobEvent deleteJobEvent) {
        DeleteJobEventAvro event = avroEventConverter.buildDeleteJobEventAvro(deleteJobEvent);
        kafkaTemplate.send(topic, event);
    }
}
