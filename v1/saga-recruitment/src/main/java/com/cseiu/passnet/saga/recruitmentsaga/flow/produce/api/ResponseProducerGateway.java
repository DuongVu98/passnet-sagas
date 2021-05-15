package com.cseiu.passnet.saga.recruitmentsaga.flow.produce.api;

import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.ResponseProducerGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
@Slf4j(topic = "[ResponseProducerGateway]")
public class ResponseProducerGateway extends ResponseProducerGrpc.ResponseProducerImplBase {

    //TODO: send response to kafka
    @Override
    public void produceSuccessResponse(ProduceEvents.SuccessResponse request, StreamObserver<ProduceEvents.SagaResponse> responseObserver) {
        super.produceSuccessResponse(request, responseObserver);
    }

    //TODO: send response to kafka
    @Override
    public void produceFailureResponse(ProduceEvents.FailureResponse request, StreamObserver<ProduceEvents.SagaResponse> responseObserver) {
        super.produceFailureResponse(request, responseObserver);
    }
}
