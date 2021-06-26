package com.cseiu.passnet.saga.usersaga.flow.consume.core.executor;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.usersaga.flow.consume.core.consumer.IMessageConsumer;
import org.springframework.stereotype.Component;

@Component
public class ConsumingExecutor {

    private final IMessageConsumer<SuccessResponse> successResponseConsumer;
    private final IMessageConsumer<FailureResponse> failureResponseConsumer;

    public ConsumingExecutor(IMessageConsumer<SuccessResponse> successResponseConsumer, IMessageConsumer<FailureResponse> failureResponseConsumer) {
        this.successResponseConsumer = successResponseConsumer;
        this.failureResponseConsumer = failureResponseConsumer;
    }

    public void consume(SuccessResponse response) {
        this.successResponseConsumer.consume(response);
    }

    public void consume(FailureResponse response) {
        this.failureResponseConsumer.consume(response);
    }
}
