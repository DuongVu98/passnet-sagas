package com.cseiu.passnet.saga.classroomsaga.flow.consume.core.executor;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cseiu.passnet.saga.classroomsaga.flow.consume.core.consumers.IMessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConsumingExecutor {

    @Qualifier("accept-student-application-event-consumer")
    private final IMessageConsumer<AcceptStudentApplicationEventAvro> acceptStudentApplicationEventConsumer;
    @Qualifier("remove-student-application-event-consumer")
    private final IMessageConsumer<RemoveStudentApplicationEventAvro> removeStudentApplicationEventConsumer;

    @Autowired
    public ConsumingExecutor(IMessageConsumer<AcceptStudentApplicationEventAvro> acceptStudentApplicationEventConsumer, IMessageConsumer<RemoveStudentApplicationEventAvro> removeStudentApplicationEventConsumer) {
        this.acceptStudentApplicationEventConsumer = acceptStudentApplicationEventConsumer;
        this.removeStudentApplicationEventConsumer = removeStudentApplicationEventConsumer;
    }

    public void consume(AcceptStudentApplicationEventAvro eventAvro) {
        this.acceptStudentApplicationEventConsumer.consume(eventAvro);
    }

    public void consume(RemoveStudentApplicationEventAvro eventAvro) {
        this.removeStudentApplicationEventConsumer.consume(eventAvro);
    }
}
