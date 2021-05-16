package com.cseiu.passnet.saga.classroomsaga.common.exceptions;

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
