package com.cseiu.passnet.saga.usersaga.flow.consume.core.consumer;

public interface IMessageConsumer<T> {
    void consume(T t);
}
