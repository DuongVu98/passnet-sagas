package com.cseiu.sagaorganizer.common.services;

import com.cse.iu.passnet.saga.avro.UserRegisteredEventAvro;
import com.cseiu.passnet.saga.organizersaga.ConsumeEvents;
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
           .setCardId(avro.getCardId())
           .setDepartmentId(avro.getDepartmentId())
           .setOrganizationId(avro.getOrganizationId())
           .build();
    }
}
