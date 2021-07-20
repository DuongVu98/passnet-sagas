package com.cseiu.sagaorganizer.flow.consume.core.consumer;

import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import com.cseiu.passnet.saga.organizersaga.EventConsumerGrpc;
import com.cseiu.sagaorganizer.common.services.ProtoBufEventConvertor;
import com.cseiu.sagaorganizer.flow.consume.core.handler.ServiceResponseHandler;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventConsumer implements IMessageConsumer<UserRegisteredEventAvro> {

    private final ProtoBufEventConvertor protoBufEventConvertor;
    private final ServiceResponseHandler serviceResponseHandler;

    @GrpcClient("organizer-service")
    private EventConsumerGrpc.EventConsumerBlockingStub eventConsumerStub;

    @Autowired
    public UserRegisteredEventConsumer(ProtoBufEventConvertor protoBufEventConvertor, ServiceResponseHandler serviceResponseHandler) {
        this.protoBufEventConvertor = protoBufEventConvertor;
        this.serviceResponseHandler = serviceResponseHandler;
    }

    @Override
    public void consume(UserRegisteredEventAvro eventAvro) {
        var protobufMessage = protoBufEventConvertor.convert(eventAvro);
        var response = eventConsumerStub.consumeUserRegisteredEvent(protobufMessage);
        serviceResponseHandler.handle(response, eventAvro.getEventId());
    }
}
