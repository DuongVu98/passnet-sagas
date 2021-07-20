package com.cseiu.passnet.sagaprofile.flow.consume.core.consumer;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cseiu.passnet.saga.profilesaga.CompensatingExecutorGrpc;
import com.cseiu.passnet.saga.profilesaga.ConsumeEvents;
import com.cseiu.passnet.sagaprofile.common.exceptions.EventNotFoundException;
import com.cseiu.passnet.sagaprofile.common.exceptions.SagaNotFoundException;
import com.cseiu.passnet.sagaprofile.common.services.EventStoreService;
import com.cseiu.passnet.sagaprofile.common.services.SagaStoreService;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "FailureResponseConsumer")
public class FailureResponseConsumer implements IMessageConsumer<FailureResponse> {
    private final SagaStoreService sagaStoreService;
    private final EventStoreService eventStoreService;

    @GrpcClient("profile-service")
    private CompensatingExecutorGrpc.CompensatingExecutorBlockingStub compensatingExecutorStub;

    @Autowired
    public FailureResponseConsumer(SagaStoreService sagaStoreService, EventStoreService eventStoreService) {
        this.sagaStoreService = sagaStoreService;
        this.eventStoreService = eventStoreService;
    }

    @Override
    public void consume(FailureResponse failureResponse) {
        try {
            this.sagaStoreService.removeSaga(failureResponse.getEventId());
            log.info("removed saga");
            log.info("compensate event [{}]", failureResponse.getEventId());
            var response = this.compensatingExecutorStub.rollback(ConsumeEvents.EventIdProtobuf.newBuilder().setEventId(failureResponse.getEventId()).build());
        } catch (SagaNotFoundException exception) {
            try {
                log.info("saga not found");
                this.eventStoreService.removeEvent(failureResponse.getEventId());
                log.info("removed event");
                log.info("compensate event [{}]", failureResponse.getEventId());
                var response = this.compensatingExecutorStub.rollback(ConsumeEvents.EventIdProtobuf.newBuilder().setEventId(failureResponse.getEventId()).build());
            } catch (EventNotFoundException e) {
                log.info("No Saga and Event found. This service did not consume event or already failed with event [{}]", failureResponse.getEventId());
            }
        }
    }
}
