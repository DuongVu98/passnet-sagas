package com.cseiu.passnet.saga.usersaga.flow.produce.core.executor;

import com.cseiu.passnet.saga.usersaga.flow.produce.core.handler.IMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import proto.ProduceEvent;

@Component
public class ProducingExecutor {

    private final IMessageProducer<ProduceEvent.UserRegisteredEvent> userRegisteredEventMessageProducer;

    @Autowired
    public ProducingExecutor(
       @Qualifier("user-registered.event.producer")
          IMessageProducer<ProduceEvent.UserRegisteredEvent> userRegisteredEventMessageProducer
    ) {
        this.userRegisteredEventMessageProducer = userRegisteredEventMessageProducer;
    }

    public void produceUserRegisteredEvent(ProduceEvent.UserRegisteredEvent event){
        userRegisteredEventMessageProducer.send(event);
    }
}
