package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Service.EventService;
import nl.novi.backend.spring.api.kerkapp.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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
        eventService.getAllEvents();
        return (List<EventDto>) ResponseEntity.ok();
    }

    @PostMapping (value="/event")
    public EventDto addEvent(@RequestBody EventDto eventDto) {
        eventService.addEvent(eventDto);
        return ResponseEntity.ok(eventDto).getBody();
    }

    @PutMapping(value="/event")
    public ResponseEntity<Object> updateEvent(@RequestBody EventDto eventDto, @RequestParam(value = "id", required = true)Long Id ) {
        eventService.updateEvent(eventDto, Id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value="/event/delete")
    public String removeEvent(@RequestParam(value = "id", required = true)Long Id ) {
        eventService.removeEvent(Id);
        String value = "event "+ Id + " is verwijderd!";
        return ResponseEntity.noContent().build().toString();
    }

    @GetMapping(value="/events")
    public List<EventDto> getEventsInRange(@RequestParam(value = "start", required = true) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate start,
                                           @RequestParam(value = "finish", required = true) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate finish) {
        return ResponseEntity.ok(eventService.getEventsInRange(start, finish)).getBody();
    }
}
