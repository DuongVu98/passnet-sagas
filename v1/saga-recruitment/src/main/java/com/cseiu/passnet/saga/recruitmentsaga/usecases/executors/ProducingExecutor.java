package com.cseiu.passnet.saga.recruitmentsaga.usecases.executors;

import com.cseiu.passnet.saga.recruitmentsaga.ProduceEvents;
import com.cseiu.passnet.saga.recruitmentsaga.usecases.producers.IMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProducingExecutor {
    private final IMessageProducer<ProduceEvents.PostNewJobEvent> postNewJobEventMessageProducer;
    private final IMessageProducer<ProduceEvents.AcceptStudentApplicationEvent> acceptStudentApplicationEventMessageProducer;
    private final IMessageProducer<ProduceEvents.RemoveStudentApplicationEvent> removeStudentApplicationEventMessageProducer;
    private final IMessageProducer<ProduceEvents.DeleteJobEvent> deleteJobEventMessageProducer;

    @Autowired
    public ProducingExecutor(@Qualifier("post-new-job-event-producer") IMessageProducer<ProduceEvents.PostNewJobEvent> postNewJobEventMessageProducer, @Qualifier("accept-student-application-event-producer") IMessageProducer<ProduceEvents.AcceptStudentApplicationEvent> acceptStudentApplicationEventIMessageProducer, IMessageProducer<ProduceEvents.RemoveStudentApplicationEvent> removeStudentApplicationEventIMessageProducer, @Qualifier("delete-job-event-producer") IMessageProducer<ProduceEvents.DeleteJobEvent> deleteJobEventMessageProducer) {
        this.postNewJobEventMessageProducer = postNewJobEventMessageProducer;
        this.acceptStudentApplicationEventMessageProducer = acceptStudentApplicationEventIMessageProducer;
        this.removeStudentApplicationEventMessageProducer = removeStudentApplicationEventIMessageProducer;
        this.deleteJobEventMessageProducer = deleteJobEventMessageProducer;
    }

    public void producePostNewJobEvent(ProduceEvents.PostNewJobEvent event) {
        postNewJobEventMessageProducer.send(event);
    }

    public void produceAcceptStudentApplicationEvent(ProduceEvents.AcceptStudentApplicationEvent event){
        acceptStudentApplicationEventMessageProducer.send(event);
    }

    public void produceRemoveStudentApplicationEvent(ProduceEvents.RemoveStudentApplicationEvent event) {
        removeStudentApplicationEventMessageProducer.send(event);
    }

    public void produceDeleteJobEvent(ProduceEvents.DeleteJobEvent event) {
        deleteJobEventMessageProducer.send(event);
    }
}
