package com.cseiu.sagaorganizer.common.services;

import com.cseiu.sagaorganizer.common.exceptions.SagaNotFoundException;
import com.cseiu.sagaorganizer.common.models.SagaOrchestrator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SagaStoreService {
    private final Map<String, SagaOrchestrator> sagaStore = new HashMap<>();

    public void storeSaga(SagaOrchestrator saga) {
        this.sagaStore.put(saga.getEventId(), saga);
    }

    public SagaOrchestrator findSaga(String eventId) {
        this.checkSagaExist(eventId);
        return this.sagaStore.get(eventId);
    }

    public void removeSaga(String eventId) {
        this.checkSagaExist(eventId);
        this.sagaStore.remove(eventId);
    }

    private void checkSagaExist(String eventId) {
        if (!this.sagaStore.containsKey(eventId)) {
            throw new SagaNotFoundException(String.format("Saga with eventId %s not found", eventId));
        }
    }
}