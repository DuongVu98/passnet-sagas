package com.cseiu.passnet.saga.classroomsaga.usecases.services;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.DeleteJobEventAvro;
import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import com.cseiu.passnet.saga.classroomsaga.ConsumeEvents;
import org.springframework.stereotype.Service;

@Service
public class ProtobufEventConvertor {
    public ConsumeEvents.PostNewJobEvent buildPostNewJobEventProtobuf(PostNewJobEventAvro avroEvent){
        return ConsumeEvents.PostNewJobEvent.newBuilder()
                .setJobId(avroEvent.getJobId())
                .setOwnerId(avroEvent.getOwnerId())
                .build();
    }

    public ConsumeEvents.AcceptStudentApplicationEvent buildAcceptStudentApplicationEventProtobuf(AcceptStudentApplicationEventAvro avroEvent){
        return ConsumeEvents.AcceptStudentApplicationEvent.newBuilder()
                .setJobId(avroEvent.getJobId())
                .setTaId(avroEvent.getTaId())
                .build();
    }

    public ConsumeEvents.RemoveStudentApplicationEvent buildRemoveStudentApplicationEventProtobuf(RemoveStudentApplicationEventAvro avroEvent){
        return ConsumeEvents.RemoveStudentApplicationEvent.newBuilder()
                .setJobId(avroEvent.getJobId())
                .setTaId(avroEvent.getTaId())
                .build();
    }

    public ConsumeEvents.DeleteJobEvent buildDeleteJobEventProtobuf(DeleteJobEventAvro avroEvent){
        return ConsumeEvents.DeleteJobEvent.newBuilder()
                .setJobId(avroEvent.getJobId())
                .build();
    }
}
