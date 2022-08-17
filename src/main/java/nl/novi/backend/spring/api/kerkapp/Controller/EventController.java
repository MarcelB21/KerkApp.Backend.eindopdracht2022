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
@RequestMapping(value = "/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping (value="/all")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @PostMapping (value="/add")
    public ResponseEntity<EventDto> addEvent(@RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.addEvent(eventDto));
    }

    @PutMapping(value="/update")
    public ResponseEntity<EventDto> updateEvent(@RequestBody EventDto eventDto, @RequestParam(value = "id", required = true)Long Id ) {
        return ResponseEntity.ok(eventService.updateEvent(eventDto, Id));
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity<String> removeEvent(@RequestParam(value = "id", required = true)Long Id ) {
        eventService.removeEvent(Id);
        return ResponseEntity.ok("event "+ Id + " is verwijderd!");
    }

    @GetMapping(value="/events")
    public ResponseEntity<List<EventDto>> getEventsInRange(@RequestParam(value = "start", required = true) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate start,
                                           @RequestParam(value = "finish", required = true) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate finish) {
        return ResponseEntity.ok(eventService.getEventsInRange(start, finish));
    }
}
