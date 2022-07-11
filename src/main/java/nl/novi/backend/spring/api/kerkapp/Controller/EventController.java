package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Events;
import nl.novi.backend.spring.api.kerkapp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private final EventService EventService;

    @Autowired
    public EventController(EventService EventService) {
        this.EventService = EventService;
    }

    @GetMapping (value="/allevents")
    public List<Events> getAllEvents() {
        return getAllEvents();
    }

    @PostMapping (value="/event")
    public Events addEvent() {
        return addEvent();
    }

    @PatchMapping(value="/event")
    public Events updateEvent() {
        return updateEvent();
    }

    @DeleteMapping(value="/event")
    public void removeEvent() {
    }

    @GetMapping(value="/events")
    public List<Events> getEventsInRange() {
        return getEventsInRange();
    }
}
