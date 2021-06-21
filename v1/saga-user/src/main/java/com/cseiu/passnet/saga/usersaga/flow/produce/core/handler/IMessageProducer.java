package com.cseiu.passnet.saga.usersaga.flow.produce.core.handler;

public interface IMessageProducer<T> {
    void send(T t);
}
