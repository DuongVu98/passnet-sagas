package com.cseiu.passnet.saga.authenticationsaga.api.pubisher;

import com.cseiu.passnet.saga.authenticationsaga.domain.event.AppEvent;
import com.cseiu.passnet.saga.authenticationsaga.domain.event.CreateUserEvent;
import org.reactivestreams.Subscriber;
import proto.Messages;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

public class GrpcPublisher implements AppPublisher<Messages.CreateUserMessage, AppEvent>{
    private final EmitterProcessor<Messages.CreateUserMessage> emitterProcessor = EmitterProcessor.create();

    @Override
    public void send(Messages.CreateUserMessage messages) {
        this.emitterProcessor.onNext(messages);
    }

    @Override
    public void subscribe(Subscriber<AppEvent> subscriber) {
        Flux.from(this.emitterProcessor)
           .map(messages -> CreateUserEvent.builder().uid(messages.getUid()).build())
           .subscribe(subscriber);
    }
}
