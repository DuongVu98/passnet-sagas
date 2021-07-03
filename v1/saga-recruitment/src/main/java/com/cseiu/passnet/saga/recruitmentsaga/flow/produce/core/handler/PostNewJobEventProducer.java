package com.cseiu.passnet.saga.recruitmentsaga.flow.produce.core.handler;

import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.AvroEventConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component("post-new-job.event.producer")
public class PostNewJobEventProducer implements IMessageProducer<ProduceEvents.PostNewJobEvent> {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final AvroEventConverter avroEventConverter;

    @Value("${config.messaging.topics.post-new-job-event}")
    private String topic;

    @Autowired
    public PostNewJobEventProducer(KafkaTemplate<String, Object> kafkaTemplate, AvroEventConverter avroEventConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.avroEventConverter = avroEventConverter;
    }

    @Override
    public void send(ProduceEvents.PostNewJobEvent postNewJobEvent) {
        var event = avroEventConverter.buildPostNewJobEventAvro(postNewJobEvent);
        kafkaTemplate.send(topic, event);
    }
}
