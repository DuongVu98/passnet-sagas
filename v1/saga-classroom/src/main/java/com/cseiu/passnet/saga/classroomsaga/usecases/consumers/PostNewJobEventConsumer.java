package com.cseiu.passnet.saga.classroomsaga.usecases.consumers;

import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import com.cseiu.passnet.saga.classroomsaga.EventConsumerGrpc;
import com.cseiu.passnet.saga.classroomsaga.usecases.services.ProtobufEventConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j(topic = "[PostNewJobEventConsumer]")
@Component(value = "post-new-job-event-consumer")
public class PostNewJobEventConsumer implements IMessageConsumer<PostNewJobEventAvro> {

    private final ProtobufEventConvertor protobufEventConvertor;
    private final EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub;

    @Autowired
    public PostNewJobEventConsumer(ProtobufEventConvertor protobufEventConvertor, EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub) {
        this.protobufEventConvertor = protobufEventConvertor;
        this.eventConsumerBlockingStub = eventConsumerBlockingStub;
    }

    @Override
    public void consume(PostNewJobEventAvro avro) {
        ConsumeEvents.PostNewJobEvent event = protobufEventConvertor.buildPostNewJobEventProtobuf(avro);
        log.info("about to consume event");
        ConsumeEvents.MainServiceResponse response = eventConsumerBlockingStub.consumePostNewJobEvent(event);
    }
}
