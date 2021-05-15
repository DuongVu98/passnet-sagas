package com.cseiu.passnet.saga.recruitmentsaga;

import com.cseiu.passnet.saga.recruitmentsaga.common.exceptions.EventNotFoundException;
import com.cseiu.passnet.saga.recruitmentsaga.common.services.EventStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class EventStoreServiceTest {
    EventStoreService eventStoreService = new EventStoreService();

    @BeforeEach
    void init() {
        this.eventStoreService.storeEvent("event-1");
        this.eventStoreService.storeEvent("event-2");
        this.eventStoreService.storeEvent("event-3");
        this.eventStoreService.storeEvent("event-4");
    }

    @Test
    void shouldThrowException_whenRemoveNotExistEvent() {
        Assertions.assertThrows(EventNotFoundException.class, () -> {
           this.eventStoreService.removeEvent("event-5");
        });
    }
}
