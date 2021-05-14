package com.cseiu.passnet.saga.recruitmentsaga.usecases.consumers;

public interface IMessageConsumer<T> {
    void consume(T t);
}
