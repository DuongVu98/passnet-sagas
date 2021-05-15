package com.cseiu.passnet.saga.recruitmentsaga.flow.produce.core.handler;

public interface IMessageProducer<T> {
    void send(T t);
}
