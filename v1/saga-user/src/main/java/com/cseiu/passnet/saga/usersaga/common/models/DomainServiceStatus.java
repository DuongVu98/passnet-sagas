package com.cseiu.passnet.saga.usersaga.common.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DomainServiceStatus {
    PROCESSING(0),
    SUCCESS(1);

    private final int value;
}