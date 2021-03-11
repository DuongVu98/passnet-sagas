package com.cseiu.passnet.saga.recruitmentsaga.usecases.producers;

import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.AvroEventConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component("post-new-job-event-producer")
public class PostNewJobEventProducer implements IMessageProducer<ProduceEvents.PostNewJobEvent> {

    private final KafkaTemplate<String, PostNewJobEventAvro> kafkaTemplate;
    private final AvroEventConverter avroEventConverter;

    @Value("${spring.kafka.producer.topics.post-new-job-event}")
    private String topic;

    @Autowired
    public PostNewJobEventProducer(@Qualifier("post-new-job") KafkaTemplate<String, PostNewJobEventAvro> kafkaTemplate, AvroEventConverter avroEventConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.avroEventConverter = avroEventConverter;
    }

    @Override
    public void send(ProduceEvents.PostNewJobEvent postNewJobEvent) {
        PostNewJobEventAvro event = avroEventConverter.buildPostNewJobEventAvro(postNewJobEvent);
        kafkaTemplate.send(topic, event);
    }
}
