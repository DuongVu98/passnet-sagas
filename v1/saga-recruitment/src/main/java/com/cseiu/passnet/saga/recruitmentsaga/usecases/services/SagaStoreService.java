package com.cseiu.passnet.saga.recruitmentsaga.usecases.services;

import com.cseiu.passnet.saga.recruitmentsaga.domain.models.SagaOrchestrator;
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
        return this.sagaStore.get(eventId);
    }

    public void removeSaga(String eventId){
        this.sagaStore.remove(eventId);
    }
}
