package com.cseiu.passnet.sagaprofile.common.services;

import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import com.cseiu.passnet.saga.profilesaga.ConsumeEvents;
import org.springframework.stereotype.Service;

@Service
public class ProtoBufEventConvertor {
    public ConsumeEvents.UserRegisteredEventProtobuf convert(UserRegisteredEventAvro avro) {
        return ConsumeEvents.UserRegisteredEventProtobuf.newBuilder()
           .setEventId(avro.getEventId())
           .setUid(avro.getUserId())
           .setUsername(avro.getUsername())
           .setEmail(avro.getEmail())
           .setFirstName(avro.getFirstName())
           .setLastName(avro.getLastName())
           .setProfileRole(avro.getProfileRole())
           .build();
    }
}
