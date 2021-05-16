package com.cseiu.passnet.saga.classroomsaga.config;

import com.cseiu.passnet.saga.classroomsaga.CompensatingExecutorGrpc;
import com.cseiu.passnet.saga.classroomsaga.EventConsumerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceCommunicationConfiguration {

    @Value("${grpc.main-service.host}")
    private String serviceHost;

    @Value("${grpc.main-service.port}")
    private int servicePort;

    @Bean
    public EventConsumerGrpc.EventConsumerBlockingStub eventProducerBlockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serviceHost, servicePort).usePlaintext().build();
        return EventConsumerGrpc.newBlockingStub(channel);
    }

    @Bean
    public CompensatingExecutorGrpc.CompensatingExecutorBlockingStub compensatingExecutorBlockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serviceHost, servicePort).usePlaintext().build();
        return CompensatingExecutorGrpc.newBlockingStub(channel);
    }
}
