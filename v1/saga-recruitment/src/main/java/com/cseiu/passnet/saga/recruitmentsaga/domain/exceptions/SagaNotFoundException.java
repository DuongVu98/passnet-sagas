package com.cseiu.passnet.saga.recruitmentsaga.domain.exceptions;

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
