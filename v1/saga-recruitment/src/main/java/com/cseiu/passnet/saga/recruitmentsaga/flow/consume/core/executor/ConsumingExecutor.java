package com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.executor;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.consumers.IMessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumingExecutor {
    private final IMessageConsumer<SuccessResponse> successResponseConsumer;
    private final IMessageConsumer<FailureResponse> failureResponseConsumer;

    @Autowired
    public ConsumingExecutor(IMessageConsumer<SuccessResponse> successResponseConsumer, IMessageConsumer<FailureResponse> failureResponseConsumer) {
        this.successResponseConsumer = successResponseConsumer;
        this.failureResponseConsumer = failureResponseConsumer;
    }

    public void consume(SuccessResponse response){
        this.successResponseConsumer.consume(response);
    }

    public void consume(FailureResponse response){
        this.failureResponseConsumer.consume(response);
    }
}