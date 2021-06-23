package com.cseiu.passnet.saga.usersaga.common.exceptions;

import lombok.Getter;

@Getter
public class SagaNotFoundException extends RuntimeException {
    public SagaNotFoundException(String message) {
        super(message);
    }

    public SagaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}