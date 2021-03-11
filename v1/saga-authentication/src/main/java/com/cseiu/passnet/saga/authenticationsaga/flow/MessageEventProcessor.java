package com.cseiu.passnet.saga.authenticationsaga.flow;

import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;

public class MessageEventProcessor extends FluxProcessor<String, Integer> {
    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(String s) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void subscribe(CoreSubscriber<? super Integer> actual) {

    }
}
