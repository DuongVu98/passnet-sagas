package com.cseiu.passnet.saga.classroomsaga.flow.consume.core.executor;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.SuccessResponse;
import com.cseiu.passnet.saga.classroomsaga.flow.consume.core.consumers.IMessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConsumingExecutor {

    private final IMessageConsumer<AcceptStudentApplicationEventAvro> acceptStudentApplicationEventConsumer;
    private final IMessageConsumer<RemoveStudentApplicationEventAvro> removeStudentApplicationEventConsumer;
    private final IMessageConsumer<SuccessResponse> successResponseConsumer;
    private final IMessageConsumer<FailureResponse> failureResponseConsumer;

    @Autowired
    public ConsumingExecutor(IMessageConsumer<AcceptStudentApplicationEventAvro> acceptStudentApplicationEventConsumer, IMessageConsumer<RemoveStudentApplicationEventAvro> removeStudentApplicationEventConsumer, IMessageConsumer<SuccessResponse> successResponseConsumer, IMessageConsumer<FailureResponse> failureResponseConsumer) {
        this.acceptStudentApplicationEventConsumer = acceptStudentApplicationEventConsumer;
        this.removeStudentApplicationEventConsumer = removeStudentApplicationEventConsumer;
        this.successResponseConsumer = successResponseConsumer;
        this.failureResponseConsumer = failureResponseConsumer;
    }

    public void consume(AcceptStudentApplicationEventAvro eventAvro) {
        this.acceptStudentApplicationEventConsumer.consume(eventAvro);
    }

    public void consume(RemoveStudentApplicationEventAvro eventAvro) {
        this.removeStudentApplicationEventConsumer.consume(eventAvro);
    }

    public void consume(SuccessResponse response){
        this.successResponseConsumer.consume(response);
    }

    public void consume(FailureResponse response){
        this.failureResponseConsumer.consume(response);
    }
}
