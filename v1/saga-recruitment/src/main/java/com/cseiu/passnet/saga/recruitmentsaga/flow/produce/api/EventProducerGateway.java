package com.cseiu.passnet.saga.recruitmentsaga.flow.produce.api;

import com.cseiu.passnet.saga.recruitmentsaga.EventProducerGrpc;
import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.flow.produce.core.executor.ProducingExecutor;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
@Slf4j(topic = "[EventProducerGateway]")
public class EventProducerGateway extends EventProducerGrpc.EventProducerImplBase {

    private final ProducingExecutor producingExecutor;

    @Autowired
    public EventProducerGateway(ProducingExecutor producingExecutor) {
        this.producingExecutor = producingExecutor;
    }

    @Override
    public void produceAcceptStudentApplicationEvent(ProduceEvents.AcceptStudentApplicationEvent request, StreamObserver<ProduceEvents.SagaResponse> responseObserver) {
        log.info("produce AcceptStudentApplicationEvent --> {}", request);

        producingExecutor.produceAcceptStudentApplicationEvent(request);
        responseObserver.onNext(ProduceEvents.SagaResponse.newBuilder().setMessage("successfully produced").build());
        responseObserver.onCompleted();
    }

    @Override
    public void producePostNewJobEvent(ProduceEvents.PostNewJobEvent request, StreamObserver<ProduceEvents.SagaResponse> responseObserver) {
        log.info("produce PostNewJobEvent --> {}", request);

        producingExecutor.producePostNewJobEvent(request);
        responseObserver.onNext(ProduceEvents.SagaResponse.newBuilder().setMessage("successfully produced").build());
        responseObserver.onCompleted();
    }

    @Override
    public void produceRemoveStudentApplicationEvent(ProduceEvents.RemoveStudentApplicationEvent request, StreamObserver<ProduceEvents.SagaResponse> responseObserver) {
        log.info("produce RemoveStudentApplicationEvent --> {}", request);

        producingExecutor.produceRemoveStudentApplicationEvent(request);
        responseObserver.onNext(ProduceEvents.SagaResponse.newBuilder().setMessage("successfully produced").build());
        responseObserver.onCompleted();
    }

    @Override
    public void produceDeleteJobEvent(ProduceEvents.DeleteJobEvent request, StreamObserver<ProduceEvents.SagaResponse> responseObserver) {
        log.info("produce DeleteJobEvent --> {}", request);

        producingExecutor.produceDeleteJobEvent(request);
        responseObserver.onNext(ProduceEvents.SagaResponse.newBuilder().setMessage("successfully produced").build());
        responseObserver.onCompleted();
    }
}
