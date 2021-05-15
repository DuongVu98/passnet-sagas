package com.cseiu.passnet.saga.recruitmentsaga;

import com.cseiu.passnet.saga.recruitmentsaga.common.exceptions.SagaNotFoundException;
import com.cseiu.passnet.saga.recruitmentsaga.common.models.DomainService;
import com.cseiu.passnet.saga.recruitmentsaga.common.models.DomainServiceNames;
import com.cseiu.passnet.saga.recruitmentsaga.common.models.SagaOrchestrator;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.SagaStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class SagaStoreServiceTest {

    SagaStoreService sagaStoreService = new SagaStoreService();

    @BeforeEach
    void init() {
        this.sagaStoreService.storeSaga(
           SagaOrchestrator.builder()
              .eventId("event-1")
              .domainServices(List.of(
                 new DomainService(DomainServiceNames.CLASSROOM_SERVICE),
                 new DomainService(DomainServiceNames.AUTHENTICATION_SERVICE)
              ))
              .build()
        );
    }

    @Test
    void shouldThrowException_whenRetrieveNotExistSaga() {
        Assertions.assertThrows(SagaNotFoundException.class, () -> {
            this.sagaStoreService.findSaga("hello");
        });
    }

    @Test
    void shouldThrowException_whenRemoveNotExistSaga() {
        Assertions.assertThrows(SagaNotFoundException.class, () -> {
            this.sagaStoreService.removeSaga("hello");
        });
    }

    @Test
    void shouldReturnSaga_whenFindSaga() {
        Assertions.assertEquals("event-1", sagaStoreService.findSaga("event-1").getEventId());
    }
}
