package com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.consumers;

public interface IMessageConsumer<T> {
    void consume(T t);
}
