package com.cseiu.passnet.saga.authenticationsaga.api.app;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import proto.MessageServiceGrpc;
import proto.Messages;

@GRpcService
@Slf4j(topic = "[MessageService]")
public class AppRequest extends MessageServiceGrpc.MessageServiceImplBase {
    @Override
    public void sendCreateUserMessage(Messages.CreateUserMessage request, StreamObserver<Messages.Response> responseObserver) {

        log.info("create new user with id: {}", request.getUid());

        Messages.Response response = Messages.Response.newBuilder().setMessage("message sent").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
