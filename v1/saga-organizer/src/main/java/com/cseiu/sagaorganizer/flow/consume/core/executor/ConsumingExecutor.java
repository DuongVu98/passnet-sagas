package com.cseiu.sagaorganizer.flow.consume.core.executor;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import com.cseiu.sagaorganizer.flow.consume.core.consumer.IMessageConsumer;
import org.springframework.stereotype.Component;

@Component
public class ConsumingExecutor {

    private final IMessageConsumer<UserRegisteredEventAvro> userRegisteredEventConsumer;
    private final IMessageConsumer<SuccessResponse> successResponseConsumer;
    private final IMessageConsumer<FailureResponse> failureResponseConsumer;

    public ConsumingExecutor(IMessageConsumer<UserRegisteredEventAvro> userRegisteredEventConsumer, IMessageConsumer<SuccessResponse> successResponseConsumer, IMessageConsumer<FailureResponse> failureResponseConsumer) {
        this.userRegisteredEventConsumer = userRegisteredEventConsumer;
        this.successResponseConsumer = successResponseConsumer;
        this.failureResponseConsumer = failureResponseConsumer;
    }


    public void consume(UserRegisteredEventAvro eventAvro) {
        this.userRegisteredEventConsumer.consume(eventAvro);
    }

    public void consume(SuccessResponse response) {
        this.successResponseConsumer.consume(response);
    }

    public void consume(FailureResponse response) {
        this.failureResponseConsumer.consume(response);
    }
}
