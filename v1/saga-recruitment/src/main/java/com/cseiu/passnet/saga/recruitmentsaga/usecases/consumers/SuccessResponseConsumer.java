package com.cseiu.passnet.saga.recruitmentsaga.usecases.consumers;

import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.recruitmentsaga.domain.models.SagaOrchestrator;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.services.SagaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "success.response.consumer")
public class SuccessResponseConsumer implements IMessageConsumer<SuccessResponse>{
    private final SagaStoreService sagaStoreService;

    @Autowired
    public SuccessResponseConsumer(SagaStoreService sagaStoreService) {
        this.sagaStoreService = sagaStoreService;
    }

    @Override
    public void consume(SuccessResponse successResponse) {
        SagaOrchestrator orchestrator = this.sagaStoreService.findSaga(successResponse.getEventId());

        orchestrator.getDomainServices().forEach(domainService -> {
            if(domainService.getServiceName().name().equals(successResponse.getServiceName())) {
                domainService.setStatusSuccess();
            }
        });
    }
}
