package com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.handler;

import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.recruitmentsaga.common.annotations.CleanupSaga;
import com.cseiu.passnet.saga.recruitmentsaga.common.exceptions.SagaNotFoundException;
import com.cseiu.passnet.saga.recruitmentsaga.common.models.SagaOrchestrator;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.SagaStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j(topic = "[SuccessResponseConsumer]")
@Component(value = "success.response.consumer")
public class SuccessResponseConsumer implements IMessageConsumer<SuccessResponse> {
    private final SagaStoreService sagaStoreService;

    @Autowired
    public SuccessResponseConsumer(SagaStoreService sagaStoreService) {
        this.sagaStoreService = sagaStoreService;
    }

    @Override
    @CleanupSaga
    public void consume(SuccessResponse successResponse) {
        try {
            SagaOrchestrator orchestrator = this.sagaStoreService.findSaga(successResponse.getEventId());

            orchestrator.getDomainServices().forEach(domainService -> {
                if (domainService.getServiceName().name().equals(successResponse.getServiceName())) {
                    domainService.setStatusSuccess();
                }
            });
        } catch (SagaNotFoundException exception) {
            log.info("SagaNotFound: This service is not a producer for this event");
        }
    }
}
