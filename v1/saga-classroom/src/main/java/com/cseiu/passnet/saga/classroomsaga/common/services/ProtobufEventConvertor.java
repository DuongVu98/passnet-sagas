package com.cseiu.passnet.saga.classroomsaga.common.services;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import org.springframework.stereotype.Service;

@Service
public class ProtobufEventConvertor {

    public ConsumeEvents.AcceptStudentApplicationEvent buildAcceptStudentApplicationEventProtobuf(AcceptStudentApplicationEventAvro avroEvent) {
        return ConsumeEvents.AcceptStudentApplicationEvent.newBuilder()
           .setJobId(avroEvent.getJobId())
           .setTaId(avroEvent.getTaId())
           .build();
    }

    public ConsumeEvents.RemoveStudentApplicationEvent buildRemoveStudentApplicationEventProtobuf(RemoveStudentApplicationEventAvro avroEvent) {
        return ConsumeEvents.RemoveStudentApplicationEvent.newBuilder()
           .setJobId(avroEvent.getJobId())
           .setTaId(avroEvent.getTaId())
           .build();
    }
}
