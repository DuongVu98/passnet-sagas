package com.cseiu.passnet.saga.usersaga.common.exceptions;

import lombok.Getter;

@Getter
public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(String message) {
        super(message);
    }

    public EventNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
