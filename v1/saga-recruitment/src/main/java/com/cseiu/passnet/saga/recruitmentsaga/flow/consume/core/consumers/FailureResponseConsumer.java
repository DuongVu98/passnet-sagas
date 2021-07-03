package com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.consumers;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cseiu.passnet.saga.recruitmentsaga.CompensatingExecutorGrpc;
import com.cseiu.passnet.saga.recruitmentsaga.ConsumeEvents;
import com.cseiu.passnet.saga.recruitmentsaga.common.exceptions.EventNotFoundException;
import com.cseiu.passnet.saga.recruitmentsaga.common.exceptions.SagaNotFoundException;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.EventStoreService;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.SagaStoreService;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "[FailureResponseConsumer]")
public class FailureResponseConsumer implements IMessageConsumer<FailureResponse> {
    private final SagaStoreService sagaStoreService;
    private final EventStoreService eventStoreService;

    @GrpcClient("recruitment-service")
    private CompensatingExecutorGrpc.CompensatingExecutorBlockingStub compensatingExecutorBlockingStub;

    @Autowired
    public FailureResponseConsumer(SagaStoreService sagaStoreService, EventStoreService eventStoreService) {
        this.sagaStoreService = sagaStoreService;
        this.eventStoreService = eventStoreService;
    }


    @Override
    public void consume(FailureResponse failureResponse) {

        try {
            this.sagaStoreService.removeSaga(failureResponse.getEventId());
            var response = this.compensatingExecutorBlockingStub.rollback(ConsumeEvents.EventId.newBuilder().setEventId(failureResponse.getEventId()).build());
        } catch (SagaNotFoundException exception) {
            try {
                this.eventStoreService.removeEvent(failureResponse.getEventId());
                var response = this.compensatingExecutorBlockingStub.rollback(ConsumeEvents.EventId.newBuilder().setEventId(failureResponse.getEventId()).build());
            } catch (EventNotFoundException e) {
                log.info("No Saga and Event found. This service does not consume event [{}]", failureResponse.getEventId());
            }
        }
    }
}
