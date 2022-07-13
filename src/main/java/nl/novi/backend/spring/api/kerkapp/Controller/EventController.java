package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Event;
import nl.novi.backend.spring.api.kerkapp.Service.EventService;
import nl.novi.backend.spring.api.kerkapp.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping (value="/allevents")
    public List<Event> getAllEvents() {
        return getAllEvents();
    }

    @PostMapping (value="/event")
    public EventDto addEvent(@RequestBody EventDto eventDto) {
        eventService.addEvent(eventDto);
        return eventDto;
    }

    @PatchMapping(value="/event")
    public Event updateEvent() {
        return updateEvent();
    }

    @DeleteMapping(value="/event")
    public void removeEvent() {
    }

//    @GetMapping(value="/events")
//    public List<EventDto> getEventsInRange(@RequestParam(value = "start", required = true) String start,
//                                           @RequestParam(value = "end", required = true) String end) {
//        return eventService.getEventsInRange(start, end);
//    }
}
