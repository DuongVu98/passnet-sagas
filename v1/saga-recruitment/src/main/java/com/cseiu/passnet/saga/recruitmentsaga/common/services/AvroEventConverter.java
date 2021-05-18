package com.cseiu.passnet.saga.recruitmentsaga.common.services;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.DeleteJobEventAvro;
import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import org.springframework.stereotype.Service;

@Service
public class AvroEventConverter {

    public PostNewJobEventAvro buildPostNewJobEventAvro(ProduceEvents.PostNewJobEvent protobufEvent) {
        return PostNewJobEventAvro.newBuilder()
           .setEventId(protobufEvent.getEventId())
           .setOwnerId(protobufEvent.getOwnerId())
           .setJobId(protobufEvent.getJobId())
           .build();
    }

    public AcceptStudentApplicationEventAvro buildAcceptStudentApplicationEventAvro(ProduceEvents.AcceptStudentApplicationEvent protobufEvent) {
        return AcceptStudentApplicationEventAvro.newBuilder()
           .setEventId(protobufEvent.getEventId())
           .setJobId(protobufEvent.getJobId())
           .setTaId(protobufEvent.getTaId())
           .build();
    }

    public RemoveStudentApplicationEventAvro buildRemoveStudentApplicationEventAvro(ProduceEvents.RemoveStudentApplicationEvent protobufEvent) {
        return RemoveStudentApplicationEventAvro.newBuilder()
           .setEventId(protobufEvent.getEventId())
           .setJobId(protobufEvent.getJobId())
           .setTaId(protobufEvent.getTaId())
           .build();
    }

    public DeleteJobEventAvro buildDeleteJobEventAvro(ProduceEvents.DeleteJobEvent protobufEvent) {
        return DeleteJobEventAvro.newBuilder()
           .setEventId(protobufEvent.getEventId())
           .setJobId(protobufEvent.getJobId())
           .build();
    }
}
