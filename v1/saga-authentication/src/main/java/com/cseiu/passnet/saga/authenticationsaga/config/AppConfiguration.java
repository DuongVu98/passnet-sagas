package com.cseiu.passnet.saga.authenticationsaga.config;

import com.cseiu.passnet.saga.authenticationsaga.api.message.MessageSender;
import com.cseiu.passnet.saga.authenticationsaga.api.pubisher.GrpcPublisher;
import com.cseiu.passnet.saga.authenticationsaga.api.subscriber.MessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;

@Configuration
public class AppConfiguration {

    MessageSender messageSender;

    @Autowired
    public AppConfiguration(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Bean
    public MessageSubscriber getSubscriber() {
        return new MessageSubscriber(messageSender);
    }
}
