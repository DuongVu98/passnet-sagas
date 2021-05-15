package com.cseiu.passnet.saga.recruitmentsaga.common.models;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SagaOrchestrator {
    private String eventId;
    private List<DomainService> domainServices;

    public boolean isSuccess() {
        int result = 1;

        for (DomainService service : domainServices) {
            result = result & service.getStatus().getValue();
        }

        return result == 1;
    }

    public void updateSuccessService(DomainServiceNames serviceName){
        this.domainServices.forEach(service -> {
            if(service.getServiceName()==serviceName) {
                service.setStatusSuccess();
            }
        });
    }
}
