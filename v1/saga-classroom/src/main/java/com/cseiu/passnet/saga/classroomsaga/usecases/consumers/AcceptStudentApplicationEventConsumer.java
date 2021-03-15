package com.cseiu.passnet.saga.classroomsaga.usecases.consumers;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import com.cseiu.passnet.saga.classroomsaga.EventConsumerGrpc;
import com.cseiu.passnet.saga.classroomsaga.usecases.services.ProtobufEventConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcceptStudentApplicationEventConsumer implements IMessageConsumer<AcceptStudentApplicationEventAvro>{

    private final ProtobufEventConvertor protobufEventConvertor;
    private final EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub;

    @Autowired
    public AcceptStudentApplicationEventConsumer(ProtobufEventConvertor protobufEventConvertor, EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub) {
        this.protobufEventConvertor = protobufEventConvertor;
        this.eventConsumerBlockingStub = eventConsumerBlockingStub;
    }

    @Override
    public void consume(AcceptStudentApplicationEventAvro avro) {
        ConsumeEvents.AcceptStudentApplicationEvent event = protobufEventConvertor.buildAcceptStudentApplicationEventProtobuf(avro);
        ConsumeEvents.SagaResponse response = eventConsumerBlockingStub.consumeAcceptStudentApplicationEvent(event);
    }
}
