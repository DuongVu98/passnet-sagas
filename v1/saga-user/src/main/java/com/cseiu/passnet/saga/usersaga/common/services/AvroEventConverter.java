package com.cseiu.passnet.saga.usersaga.common.services;

import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import org.springframework.stereotype.Service;
import proto.ProduceEvent;

@Service
public class AvroEventConverter {
    public UserRegisteredEventAvro build(ProduceEvent.UserRegisteredEvent event) {
        return UserRegisteredEventAvro.newBuilder()
           .setEventId(event.getEventId())
           .setUserId(event.getUid())
           .setUsername(event.getUsername())
           .setEmail(event.getEmail())
           .setFirstName(event.getFirstName())
           .setLastName(event.getLastName())
           .setProfileRole(event.getProfileRole())
           .build();
    }
}
