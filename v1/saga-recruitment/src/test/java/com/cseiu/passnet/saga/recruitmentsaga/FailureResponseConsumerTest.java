package com.cseiu.passnet.saga.recruitmentsaga;

import com.cse.iu.passnet.saga.avro.FailureResponse;
import com.cseiu.passnet.saga.recruitmentsaga.common.models.DomainService;
import com.cseiu.passnet.saga.recruitmentsaga.common.models.DomainServiceNames;
import com.cseiu.passnet.saga.recruitmentsaga.common.models.SagaOrchestrator;
import com.cseiu.passnet.saga.recruitmentsaga.flow.consume.core.consumers.FailureResponseConsumer;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.EventStoreService;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.SagaStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class FailureResponseConsumerTest {

    @Mock
    CompensatingExecutorGrpc.CompensatingExecutorBlockingStub compensatingExecutorBlockingStub;
    SagaStoreService sagaStoreService;
    EventStoreService eventStoreService;

    FailureResponseConsumer failureResponseConsumer;

    ConsumeEvents.ServiceResponse response = ConsumeEvents.ServiceResponse.newBuilder().setMessage("rollback successfully").build();

    @BeforeEach
    void init() {
        sagaStoreService.storeSaga(
           SagaOrchestrator.builder()
              .eventId("eventFromProducer")
              .domainServices(List.of(
                 new DomainService(DomainServiceNames.AUTHENTICATION_SERVICE),
                 new DomainService(DomainServiceNames.CLASSROOM_SERVICE)
              ))
              .build()
        );

        eventStoreService.storeEvent("event-1");
        eventStoreService.storeEvent("event-2");
        eventStoreService.storeEvent("event-3");
        eventStoreService.storeEvent("event-4");

        Mockito.when(compensatingExecutorBlockingStub.rollback(Mockito.any())).thenReturn(response);

        failureResponseConsumer = new FailureResponseConsumer(sagaStoreService, eventStoreService, compensatingExecutorBlockingStub);
    }

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() -> {
            this.failureResponseConsumer.consume(
               FailureResponse.newBuilder()
                  .setEventId("eventFromProducer")
                  .setServiceName(DomainServiceNames.AUTHENTICATION_SERVICE.name())
                  .build()
            );
        });
    }
}
