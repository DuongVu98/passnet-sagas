package com.cseiu.passnet.sagaprofile.flow.consume.core.consumer;

import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import com.cseiu.passnet.saga.profilesaga.EventConsumerRpcGrpc;
import com.cseiu.passnet.sagaprofile.common.services.ProtoBufEventConvertor;
import com.cseiu.passnet.sagaprofile.flow.consume.core.handler.ServiceResponseHandler;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventConsumer implements IMessageConsumer<UserRegisteredEventAvro> {

    private final ProtoBufEventConvertor protoBufEventConvertor;
    private final ServiceResponseHandler serviceResponseHandler;

    @GrpcClient("profile-service")
    private EventConsumerRpcGrpc.EventConsumerRpcBlockingStub eventConsumerStub;

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
