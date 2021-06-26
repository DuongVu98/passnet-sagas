package com.cseiu.passnet.saga.usersaga.flow.consume.core.consumer;

import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.usersaga.common.annotations.CleanupSaga;
import com.cseiu.passnet.saga.usersaga.common.exceptions.SagaNotFoundException;
import com.cseiu.passnet.saga.usersaga.common.models.SagaOrchestrator;
import com.cseiu.passnet.saga.usersaga.common.services.SagaStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "SuccessResponseConsumer")
public class SuccessResponseConsumer implements IMessageConsumer<SuccessResponse> {

    private final SagaStoreService sagaStoreService;

    @Autowired
    public SuccessResponseConsumer(SagaStoreService sagaStoreService) {
        this.sagaStoreService = sagaStoreService;
    }

    @Override
    @CleanupSaga
    public void consume(SuccessResponse response) {
        try {
            SagaOrchestrator orchestrator = this.sagaStoreService.findSaga(response.getEventId());

            orchestrator.getDomainServices().forEach(domainService -> {
                if (domainService.getServiceName().name().equals(response.getServiceName())) {
                    domainService.setStatusSuccess();
                }
            });
        } catch (SagaNotFoundException exception) {
            log.info("SagaNotFound: This service is not a producer for this event");
        }
    }
}
