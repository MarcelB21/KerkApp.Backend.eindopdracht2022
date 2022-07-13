package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import nl.novi.backend.spring.api.kerkapp.Entitiy.Event;
import nl.novi.backend.spring.api.kerkapp.Exception.BadDateFormatException;
import nl.novi.backend.spring.api.kerkapp.Repository.EventRepository;
import nl.novi.backend.spring.api.kerkapp.dto.BibleDto;
import nl.novi.backend.spring.api.kerkapp.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService (EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events;
    } 

    public Event addEvent(EventDto eventDto) {
        return eventRepository.save(fromDto(eventDto));
    }

    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void removeEvent(Event event) {
        eventRepository.delete(event);
    }

//    public List<EventDto> getEventsInRange(String start, String end) {
//        Date startDate = null;
//        Date endDate = null;
//        SimpleDateFormat inputDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            startDate = inputDateFormat.parse(start);
//        } catch (ParseException e) {
//            throw new BadDateFormatException("bad start date: " + start);
//        }
//
//        try {
//            endDate = inputDateFormat.parse(end);
//        } catch (ParseException e) {
//            throw new BadDateFormatException("bad end date: " + end);
//        }
//
//        LocalDateTime startDateTime = LocalDateTime.ofInstant(startDate.toInstant(),
//                ZoneId.systemDefault());
//
//        LocalDateTime endDateTime = LocalDateTime.ofInstant(endDate.toInstant(),
//                ZoneId.systemDefault());
//
//        List<Event> events = eventRepository.findByStartGreaterThanEqualAndFinishLessThanEqual(startDate, endDate);
//        List<EventDto> eventDtos = new ArrayList<>();
//        for (Event event: events) {
//            eventDtos.add(toDto(event));
//        }
//        return eventDtos;
//    }

    public Event fromDto(EventDto eventDto)  {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setStart(eventDto.getStart());
        event.setFinish(eventDto.getFinish());
        return event;
    }

    public EventDto toDto(Event event)  {
        EventDto eventDto = new EventDto();
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setStart(event.getStart());
        eventDto.setFinish(event.getFinish());
        return eventDto;
    }

}
