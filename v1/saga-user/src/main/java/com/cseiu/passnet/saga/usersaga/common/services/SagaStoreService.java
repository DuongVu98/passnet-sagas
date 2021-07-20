package com.cseiu.passnet.saga.usersaga.common.services;

import com.cseiu.passnet.saga.usersaga.common.exceptions.SagaNotFoundException;
import com.cseiu.passnet.saga.usersaga.common.models.SagaOrchestrator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j(topic = "[SagaStoreService]")
public class SagaStoreService {
    private final Map<String, SagaOrchestrator> sagaStore = new HashMap<>();

    public void storeSaga(SagaOrchestrator saga) {
        log.info("Store saga with event [{}]", saga.getEventId());
        this.sagaStore.put(saga.getEventId(), saga);
    }

    public SagaOrchestrator findSaga(String eventId) {
        this.checkSagaExist(eventId);
        return this.sagaStore.get(eventId);
    }

    public void removeSaga(String eventId){
        log.info("Store saga with event [{}]", eventId);
        this.checkSagaExist(eventId);
        this.sagaStore.remove(eventId);
    }

    private void checkSagaExist(String eventId) {
        if (!this.sagaStore.containsKey(eventId)) {
            throw new SagaNotFoundException(String.format("Saga with eventId %s not found", eventId));
        }
    }
}
