package com.cseiu.passnet.saga.classroomsaga.usecases.consumers;

import com.cse.iu.passnet.saga.avro.DeleteJobEventAvro;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import com.cseiu.passnet.saga.classroomsaga.EventConsumerGrpc;
import com.cseiu.passnet.saga.classroomsaga.usecases.services.ProtobufEventConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteJobEventConsumer implements IMessageConsumer<DeleteJobEventAvro>{

    private final ProtobufEventConvertor protobufEventConvertor;
    private final EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub;

    @Autowired
    public DeleteJobEventConsumer(ProtobufEventConvertor protobufEventConvertor, EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub) {
        this.protobufEventConvertor = protobufEventConvertor;
        this.eventConsumerBlockingStub = eventConsumerBlockingStub;
    }


    @Override
    public void consume(DeleteJobEventAvro avro) {
        ConsumeEvents.DeleteJobEvent event = protobufEventConvertor.buildDeleteJobEventProtobuf(avro);
        ConsumeEvents.SagaResponse response = eventConsumerBlockingStub.consumeDeleteJobEvent(event);
    }
}
