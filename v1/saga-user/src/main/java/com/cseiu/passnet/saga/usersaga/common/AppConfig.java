package com.cseiu.passnet.saga.usersaga.common;

import com.cseiu.passnet.saga.classroomsaga.CompensatingExecutorGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean(value = "bean-compensating-stub")
    public CompensatingExecutorGrpc.CompensatingExecutorBlockingStub compensatingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7071).usePlaintext().build();
        return CompensatingExecutorGrpc.newBlockingStub(channel);
    }
}
