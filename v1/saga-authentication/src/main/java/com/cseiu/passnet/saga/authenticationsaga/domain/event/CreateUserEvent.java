package com.cseiu.passnet.saga.authenticationsaga.domain.event;

import lombok.Builder;

@Builder
public class CreateUserEvent extends AppEvent{
    private String uid;
}
