package com.cseiu.passnet.saga.usersaga.common.services;

import com.cseiu.passnet.saga.usersaga.common.exceptions.EventNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j(topic = "[EventStoreService]")
public class EventStoreService {
    private final List<String> eventStore = new ArrayList<>();

    public void storeEvent(String eventId) {
        log.info("Store event [{}]", eventId);
        this.eventStore.add(eventId);
    }

    public boolean contains(String eventId){
        return this.eventStore.contains(eventId);
    }

    public void removeEvent(String eventId){
        log.info("Remove event [{}]", eventId);
        this.checkEventExist(eventId);
        this.eventStore.remove(eventId);
    }

    private void checkEventExist(String eventId) {
        if(!this.eventStore.contains(eventId)) {
            throw new EventNotFoundException(String.format("event with eventId %s not found", eventId));
        }
    }
}
