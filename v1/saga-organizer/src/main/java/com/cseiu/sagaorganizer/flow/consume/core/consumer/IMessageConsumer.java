package com.cseiu.sagaorganizer.flow.consume.core.consumer;

public interface IMessageConsumer<T> {
    void consume(T t);
}
