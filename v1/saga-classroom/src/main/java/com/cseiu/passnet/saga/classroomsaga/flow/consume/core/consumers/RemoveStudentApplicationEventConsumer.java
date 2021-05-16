package com.cseiu.passnet.saga.classroomsaga.flow.consume.core.consumers;

import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import com.cseiu.passnet.saga.classroomsaga.EventConsumerGrpc;
import com.cseiu.passnet.saga.classroomsaga.common.services.ProtobufEventConvertor;
import com.cseiu.passnet.saga.classroomsaga.flow.consume.core.handler.ServiceResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "remove-student-application-event-consumer")
public class RemoveStudentApplicationEventConsumer implements IMessageConsumer<RemoveStudentApplicationEventAvro>{

    private final ProtobufEventConvertor protobufEventConvertor;
    private final EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub;
    private final ServiceResponseHandler serviceResponseHandler;

    @Autowired
    public RemoveStudentApplicationEventConsumer(ProtobufEventConvertor protobufEventConvertor, EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub, ServiceResponseHandler serviceResponseHandler) {
        this.protobufEventConvertor = protobufEventConvertor;
        this.eventConsumerBlockingStub = eventConsumerBlockingStub;
        this.serviceResponseHandler = serviceResponseHandler;
    }

    @Override
    public void consume(RemoveStudentApplicationEventAvro avro) {
        ConsumeEvents.RemoveStudentApplicationEvent event = protobufEventConvertor.buildRemoveStudentApplicationEventProtobuf(avro);
        ConsumeEvents.ServiceResponse response = eventConsumerBlockingStub.consumeRemoveStudentApplicationEvent(event);

        this.serviceResponseHandler.handle(response, avro.getEventId());
    }
}
