package com.cseiu.passnet.sagaprofile.flow.consume.core.consumer;

import com.cse.iu.passnet.saga.avro.SuccessResponse;
import org.springframework.stereotype.Component;

@Component
public class SuccessResponseConsumer implements IMessageConsumer<SuccessResponse> {
    @Override
    public void consume(SuccessResponse response) {

    }
}
