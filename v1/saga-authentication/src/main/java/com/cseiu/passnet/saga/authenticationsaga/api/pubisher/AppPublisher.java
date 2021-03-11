package com.cseiu.passnet.saga.authenticationsaga.api.pubisher;

import org.reactivestreams.Subscriber;

public interface AppPublisher<IN, OUT> {
    void send(IN t);
    void subscribe(Subscriber<OUT> subscriber);
}
