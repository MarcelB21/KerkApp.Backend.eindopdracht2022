package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Events;
import nl.novi.backend.spring.api.kerkapp.Exception.BadDateFormatException;
import nl.novi.backend.spring.api.kerkapp.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class EventService<eventJpaRepository> {

    private final EventRepository eventJpaRepository;

    @Autowired
    public EventService (EventRepository eventRepository) {
        this.eventJpaRepository = eventRepository;
    }

    public List<Events> getAllEvents() {
        List<Events> events = eventJpaRepository.findAll();
        return events;
    } 

    public Events addEvent(Events events) {
        Events created = eventJpaRepository.save(events);
        return created;
    }

    public Events updateEvent(Events events) {
        return eventJpaRepository.save(events);
    }

    public void removeEvent(Events events) {
        eventJpaRepository.delete(events);
    }

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
