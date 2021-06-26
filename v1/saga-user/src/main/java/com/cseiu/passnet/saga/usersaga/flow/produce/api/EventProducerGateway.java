package com.cseiu.passnet.saga.usersaga.flow.produce.api;

import com.cseiu.passnet.saga.usersaga.flow.produce.core.executor.ProducingExecutor;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import proto.EventProducerGrpc;
import proto.ProduceEvent;

@GrpcService
@Slf4j(topic = "[EventProducerGateway]")
public class EventProducerGateway extends EventProducerGrpc.EventProducerImplBase {

    private final ProducingExecutor producingExecutor;

    @Autowired
    public EventProducerGateway(ProducingExecutor producingExecutor) {
        this.producingExecutor = producingExecutor;
    }

    @Override
    public void produceUserRegisteredEvent(ProduceEvent.UserRegisteredEvent request, StreamObserver<ProduceEvent.SagaResponse> responseObserver) {
        log.info("Receive producing request: {}", request);
        producingExecutor.produceUserRegisteredEvent(request);
        ProduceEvent.SagaResponse response = ProduceEvent.SagaResponse.newBuilder()
           .setMessage("OK")
           .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
