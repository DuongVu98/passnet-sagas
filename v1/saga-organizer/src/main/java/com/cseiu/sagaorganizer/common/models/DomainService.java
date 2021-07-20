package com.cseiu.sagaorganizer.common.models;

import lombok.Getter;

@Getter
public class DomainService {
    private DomainServiceNames serviceName;
    private DomainServiceStatus status;

    public DomainService(DomainServiceNames serviceName) {
        this.serviceName = serviceName;
        this.status = DomainServiceStatus.PROCESSING;
    }

    public void setStatusSuccess() {
        this.status = DomainServiceStatus.SUCCESS;
    }
}
