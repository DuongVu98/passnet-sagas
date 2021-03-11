package com.cseiu.passnet.saga.recruitmentsaga.usecases.producers;

public interface IMessageProducer<T> {
    void send(T t);
}
