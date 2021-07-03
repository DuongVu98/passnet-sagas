package com.cseiu.passnet.saga.classroomsaga.flow.consume.core.consumers;

import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import com.cseiu.passnet.saga.classroomsaga.EventConsumerGrpc;
import com.cseiu.passnet.saga.classroomsaga.common.services.ProtobufEventConvertor;
import com.cseiu.passnet.saga.classroomsaga.flow.consume.core.handler.ServiceResponseHandler;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "remove-student-application-event-consumer")
public class RemoveStudentApplicationEventConsumer implements IMessageConsumer<RemoveStudentApplicationEventAvro>{

    private final ProtobufEventConvertor protobufEventConvertor;
    private final ServiceResponseHandler serviceResponseHandler;

    @GrpcClient("classroom-service")
    private EventConsumerGrpc.EventConsumerBlockingStub eventConsumerBlockingStub;

    @Autowired
    public RemoveStudentApplicationEventConsumer(ProtobufEventConvertor protobufEventConvertor, ServiceResponseHandler serviceResponseHandler) {
        this.protobufEventConvertor = protobufEventConvertor;
        this.serviceResponseHandler = serviceResponseHandler;
    }


    @Override
    public void consume(RemoveStudentApplicationEventAvro avro) {
        var event = protobufEventConvertor.buildRemoveStudentApplicationEventProtobuf(avro);
        var response = eventConsumerBlockingStub.consumeRemoveStudentApplicationEvent(event);
        this.serviceResponseHandler.handle(response, avro.getEventId());
    }
}
