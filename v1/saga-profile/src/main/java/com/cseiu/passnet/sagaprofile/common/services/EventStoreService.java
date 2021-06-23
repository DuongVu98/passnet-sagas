package com.cseiu.passnet.sagaprofile.common.services;

import com.cseiu.passnet.sagaprofile.common.exceptions.EventNotFoundException;
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
        this.checkEventExist(eventId);
        this.eventStore.remove(eventId);
    }

    private void checkEventExist(String eventId) {
        if(!this.eventStore.contains(eventId)) {
            throw new EventNotFoundException(String.format("event with eventId %s not found", eventId));
        }
    }
}
