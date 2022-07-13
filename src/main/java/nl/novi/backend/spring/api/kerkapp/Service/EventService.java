package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Event;
import nl.novi.backend.spring.api.kerkapp.Repository.EventRepository;
import nl.novi.backend.spring.api.kerkapp.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService (EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDto> eventDtos = new ArrayList<>();
        for (Event event: events) {
            eventDtos.add(toDto(event));
        }
        return eventDtos;
    }

    public EventDto addEvent(EventDto eventDto) {
        eventRepository.save(fromDto(eventDto));
        return eventDto;
    }

    public EventDto updateEvent(EventDto eventDto, Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event: " + id + " is niet gevonden!"));
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setStart(eventDto.getStart());
        event.setFinish(eventDto.getFinish());
        eventRepository.save(event);
        return toDto(event);
    }

    public void removeEvent(Long Id) {
        eventRepository.deleteById(Id);
    }

    public List<EventDto> getEventsInRange(LocalDate start, LocalDate finish) {
        List<Event> events = eventRepository.findByStartGreaterThanEqualAndFinishLessThanEqual(start, finish);
        List<EventDto> eventDtos = new ArrayList<>();
        for (Event event: events) {
            eventDtos.add(toDto(event));
        }
        return eventDtos;
    }

    public Event fromDto(EventDto eventDto)  {
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setStart(eventDto.getStart());
        event.setFinish(eventDto.getFinish());
        return event;
    }

    public EventDto toDto(Event event)  {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setStart(event.getStart());
        eventDto.setFinish(event.getFinish());
        return eventDto;
    }

}
