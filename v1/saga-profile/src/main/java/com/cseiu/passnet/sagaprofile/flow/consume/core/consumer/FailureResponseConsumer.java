package com.cseiu.passnet.sagaprofile.flow.consume.core.consumer;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import org.springframework.stereotype.Component;

@Component
public class FailureResponseConsumer implements IMessageConsumer<FailureResponse>{
    @Override
    public void consume(FailureResponse failureResponse) {

    }
}
