package com.cseiu.passnet.sagaprofile.flow.consume.core.consumer;

import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventConsumer implements IMessageConsumer<UserRegisteredEventAvro>{

    @Override
    public void consume(UserRegisteredEventAvro eventAvro) {

    }
}
