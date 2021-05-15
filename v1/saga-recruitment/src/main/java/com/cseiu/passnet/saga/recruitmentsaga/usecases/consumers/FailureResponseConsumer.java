package com.cseiu.passnet.saga.recruitmentsaga.usecases.consumers;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cseiu.passnet.saga.recruitmentsaga.CompensatingExecutorGrpc;
import com.cseiu.passnet.saga.recruitmentsaga.ConsumeEvents;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.EventStoreService;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.SagaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "failure.response.consumer")
public class FailureResponseConsumer implements IMessageConsumer<FailureResponse> {
    private final SagaStoreService sagaStoreService;
    private final EventStoreService eventStoreService;
    private final CompensatingExecutorGrpc.CompensatingExecutorBlockingStub compensatingExecutorBlockingStub;

    @Autowired
    public FailureResponseConsumer(SagaStoreService sagaStoreService, EventStoreService eventStoreService, CompensatingExecutorGrpc.CompensatingExecutorBlockingStub compensatingExecutorBlockingStub) {
        this.sagaStoreService = sagaStoreService;
        this.eventStoreService = eventStoreService;
        this.compensatingExecutorBlockingStub = compensatingExecutorBlockingStub;
    }

    @Override
    public void consume(FailureResponse failureResponse) {

        this.sagaStoreService.removeSaga(failureResponse.getEventId());
        this.eventStoreService.removeEvent(failureResponse.getEventId());

        /**
         *TODO:
         * If eventId exists -> rollback
         * Else -> do nothing
         */
        ConsumeEvents.ServiceResponse response = this.compensatingExecutorBlockingStub.rollback(ConsumeEvents.EventId.newBuilder().setEventId(failureResponse.getEventId()).build());
    }
}
