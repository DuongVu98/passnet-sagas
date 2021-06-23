package com.cseiu.passnet.sagaprofile.flow.consume.core.consumer;

public interface IMessageConsumer<T> {
    void consume(T t);
}
