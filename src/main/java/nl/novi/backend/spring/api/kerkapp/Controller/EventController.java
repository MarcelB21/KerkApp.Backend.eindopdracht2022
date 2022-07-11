package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Events;
import nl.novi.backend.spring.api.kerkapp.Exception.BadDateFormatException;
import nl.novi.backend.spring.api.kerkapp.Repository.EventJpaRepository;
import nl.novi.backend.spring.api.kerkapp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventJpaRepository eventJpaRepository;
    private EventService EventService;

    @GetMapping (value="/allevents")
    public List<Events> getAllEvents() {
        return EventService.findAll();
    }

    @RequestMapping(value="/event", method=RequestMethod.POST)
    public Events addEvent(@RequestBody Events events) {
        Events created = eventJpaRepository.save(events);
        return created;
    }

    @RequestMapping(value="/event", method=RequestMethod.PATCH)
    public Events updateEvent(@RequestBody Events events) {
        return eventJpaRepository.save(events);
    }

    @RequestMapping(value="/event", method=RequestMethod.DELETE)
    public void removeEvent(@RequestBody Events events) {
        eventJpaRepository.delete(events);
    }

    @RequestMapping(value="/events", method=RequestMethod.GET)
    public List<Events> getEventsInRange(@RequestParam(value = "start", required = true) String start,
                                         @RequestParam(value = "end", required = true) String end) {
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat inputDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDate = inputDateFormat.parse(start);
        } catch (ParseException e) {
            throw new BadDateFormatException("bad start date: " + start);
        }

        try {
            endDate = inputDateFormat.parse(end);
        } catch (ParseException e) {
            throw new BadDateFormatException("bad end date: " + end);
        }

        LocalDateTime startDateTime = LocalDateTime.ofInstant(startDate.toInstant(),
                ZoneId.systemDefault());

        LocalDateTime endDateTime = LocalDateTime.ofInstant(endDate.toInstant(),
                ZoneId.systemDefault());

        return eventJpaRepository.findByStartGreaterThanEqualAndFinishLessThanEqual(startDateTime, endDateTime);
    }
}
