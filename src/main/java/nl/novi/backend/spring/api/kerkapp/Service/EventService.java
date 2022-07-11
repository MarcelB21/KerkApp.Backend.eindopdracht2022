package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Events;
import nl.novi.backend.spring.api.kerkapp.Repository.EventJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService<eventJpaRepository> {

    private final eventJpaRepository eventJpaRepository;

    @Autowired
    public EventService (eventJpaRepository eventRepository) {
        this.eventJpaRepository = eventRepository;
    }

    public List<Events> getAllEvents() {
        List<Events> events;
        events = eventJpaRepository.findAll();
        return (List<Events>) transferEvents((Events) events);
    } 
    
    public Events transferEvents(Events Events) {
        transferEvents().setId(Events.getId());
        transferEvents().setTitle(Events.getTitle());
        transferEvents().setDescription(Events.getDescription());
        transferEvents().setStart(Events.getFinish());
        transferEvents().setFinish(Events.getFinish());
    }

}
