package com.cseiu.passnet.saga.classroomsaga.flow.consume.core.consumers;

public interface IMessageConsumer<T> {
    void consume(T t);
}
