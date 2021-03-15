package com.cseiu.passnet.saga.classroomsaga.usecases.consumers;

public interface IMessageConsumer<T> {
    void consume(T t);
}
