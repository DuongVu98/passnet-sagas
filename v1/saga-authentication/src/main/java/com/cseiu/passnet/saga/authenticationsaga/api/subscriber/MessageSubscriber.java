package com.cseiu.passnet.saga.authenticationsaga.api.subscriber;

import com.cseiu.passnet.saga.authenticationsaga.api.message.MessageSender;
import com.cseiu.passnet.saga.authenticationsaga.domain.event.AppEvent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import proto.Messages;

public class MessageSubscriber implements Subscriber<AppEvent> {

    private final MessageSender sender;

    public MessageSubscriber(MessageSender sender) {
        this.sender = sender;
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(AppEvent event) {
        this.sender.sendEvent(event);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
