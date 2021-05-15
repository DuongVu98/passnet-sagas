package com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.handler;

public interface IMessageConsumer<T> {
    void consume(T t);
}
