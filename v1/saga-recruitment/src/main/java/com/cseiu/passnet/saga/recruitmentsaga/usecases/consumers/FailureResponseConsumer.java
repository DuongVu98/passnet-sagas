package com.cseiu.passnet.saga.recruitmentsaga.usecases.consumers;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.EventStoreService;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.SagaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "failure.response.consumer")
public class FailureResponseConsumer implements IMessageConsumer<FailureResponse> {
    private final SagaStoreService sagaStoreService;
    private final EventStoreService eventStoreService;

    @Autowired
    public FailureResponseConsumer(SagaStoreService sagaStoreService, EventStoreService eventStoreService) {
        this.sagaStoreService = sagaStoreService;
        this.eventStoreService = eventStoreService;
    }

    @Override
    public void consume(FailureResponse failureResponse) {
        // No kafka produce here

        this.sagaStoreService.removeSaga(failureResponse.getEventId());
        this.eventStoreService.removeEvent(failureResponse.getEventId());

        // TODO: If eventId exists --> do rollback
    }
}
