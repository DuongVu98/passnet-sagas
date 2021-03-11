package com.cseiu.passnet.saga.authenticationsaga.api.message;

import com.cseiu.passnet.saga.authenticationsaga.domain.event.AppEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Value(value = "${messages.kafka.event-topics.create-user-event}")
    private String testTopic;

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MessageSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send(testTopic, msg);
    }

    public void sendEvent(AppEvent event){

    }
}
