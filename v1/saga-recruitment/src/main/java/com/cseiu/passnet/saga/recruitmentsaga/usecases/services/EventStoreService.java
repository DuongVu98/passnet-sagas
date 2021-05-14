package com.cseiu.passnet.saga.recruitmentsaga.usecases.services;

import com.cseiu.passnet.saga.recruitmentsaga.domain.models.SagaOrchestrator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventStoreService {
    private final List<String> eventStore = new ArrayList<>();

    public void storeEvent(String eventId) {
        this.eventStore.add(eventId);
    }

    public boolean contains(String eventId){
        return this.eventStore.contains(eventId);
    }

    public void removeEvent(String eventId){
        this.eventStore.remove(eventId);
    }
}
