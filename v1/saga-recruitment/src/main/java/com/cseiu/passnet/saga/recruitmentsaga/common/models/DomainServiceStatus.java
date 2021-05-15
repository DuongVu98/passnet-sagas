package com.cseiu.passnet.saga.recruitmentsaga.common.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DomainServiceStatus {
    PROCESSING(0),
    SUCCESS(1);

    public int value;
}
