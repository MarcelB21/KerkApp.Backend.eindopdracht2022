package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Service.EventService;
import nl.novi.backend.spring.api.kerkapp.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping (value="/allevents")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping (value="/event")
    public EventDto addEvent(@RequestBody EventDto eventDto) {
        eventService.addEvent(eventDto);
        return eventDto;
    }

    @PutMapping(value="/event")
    public EventDto updateEvent(@RequestBody EventDto eventDto, @RequestParam(value = "id", required = true)Long Id ) {
        return eventService.updateEvent(eventDto, Id);
    }

    @DeleteMapping(value="/event/delete")
    public String removeEvent(@RequestParam(value = "id", required = true)Long Id ) {
        eventService.removeEvent(Id);
        return "event "+ Id + " is verwijderd!";
    }

    @GetMapping(value="/events")
    public List<EventDto> getEventsInRange(@RequestParam(value = "start", required = true) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate start,
                                           @RequestParam(value = "finish", required = true) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate finish) {
        return eventService.getEventsInRange(start, finish);
    }
}
