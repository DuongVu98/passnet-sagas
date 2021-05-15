package com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.handler;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cseiu.passnet.saga.recruitmentsaga.CompensatingExecutorGrpc;
import com.cseiu.passnet.saga.recruitmentsaga.ConsumeEvents;
import com.cseiu.passnet.saga.recruitmentsaga.common.exceptions.EventNotFoundException;
import com.cseiu.passnet.saga.recruitmentsaga.common.exceptions.SagaNotFoundException;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.EventStoreService;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.SagaStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j(topic = "[FailureResponseConsumer]")
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

        try {
            this.sagaStoreService.removeSaga(failureResponse.getEventId());
            ConsumeEvents.ServiceResponse response = this.compensatingExecutorBlockingStub.rollback(ConsumeEvents.EventId.newBuilder().setEventId(failureResponse.getEventId()).build());
        } catch (SagaNotFoundException exception) {
            try {
                this.eventStoreService.removeEvent(failureResponse.getEventId());
                ConsumeEvents.ServiceResponse response = this.compensatingExecutorBlockingStub.rollback(ConsumeEvents.EventId.newBuilder().setEventId(failureResponse.getEventId()).build());
            } catch (EventNotFoundException e) {
                log.info("No Saga and Event found. This service does not consume event [{}]", failureResponse.getEventId());
            }
        }
    }
}
