package com.cseiu.passnet.saga.classroomsaga.usecases.consumers;

import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import com.cseiu.passnet.saga.classroomsaga.EventConsumerGrpc;
import com.cseiu.passnet.saga.classroomsaga.usecases.services.ProtobufEventConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveStudentApplicationEventConsumer implements IMessageConsumer<RemoveStudentApplicationEventAvro>{

    private final ProtobufEventConvertor protobufEventConvertor;
    private final EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub;

    @Autowired
    public RemoveStudentApplicationEventConsumer(ProtobufEventConvertor protobufEventConvertor, EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub) {
        this.protobufEventConvertor = protobufEventConvertor;
        this.eventConsumerBlockingStub = eventConsumerBlockingStub;
    }

    @Override
    public void consume(RemoveStudentApplicationEventAvro avro) {
        ConsumeEvents.RemoveStudentApplicationEvent event = protobufEventConvertor.buildRemoveStudentApplicationEventProtobuf(avro);
        ConsumeEvents.SagaResponse response = eventConsumerBlockingStub.consumeRemoveStudentApplicationEvent(event);
    }
}
