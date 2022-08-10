package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Event;
import nl.novi.backend.spring.api.kerkapp.Repository.EventRepository;
import nl.novi.backend.spring.api.kerkapp.dto.EventDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventRepository mockEventRepository;

    private EventService eventServiceUnderTest;

    @BeforeEach
    void setUp() {
        eventServiceUnderTest = new EventService(mockEventRepository);
    }

    @Test
    void testGetAllEvents() {
        // Setup
        // Configure EventRepository.findAll(...).
        final List<Event> events = List.of(
                new Event(0L, "title", "description", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        when(mockEventRepository.findAll()).thenReturn(events);

        // Run the test
        final List<EventDto> result = eventServiceUnderTest.getAllEvents();

        // Verify the results
    }

    @Test
    void testGetAllEvents_EventRepositoryReturnsNoItems() {
        // Setup
        when(mockEventRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<EventDto> result = eventServiceUnderTest.getAllEvents();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testAddEvent() {
        // Setup
        final EventDto eventDto = new EventDto();
        eventDto.setTitle("title");
        eventDto.setDescription("description");
        eventDto.setStart(LocalDate.of(2020, 1, 1));
        eventDto.setFinish(LocalDate.of(2020, 1, 1));
        eventDto.setId(0L);

        // Configure EventRepository.save(...).
        final Event event = new Event(0L, "title", "description", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1));
        when(mockEventRepository.save(any(Event.class))).thenReturn(event);

        // Run the test
        final EventDto result = eventServiceUnderTest.addEvent(eventDto);

        // Verify the results
        verify(mockEventRepository).save(any(Event.class));
    }

    @Test
    void testUpdateEvent() {
        // Setup
        final EventDto eventDto = new EventDto();
        eventDto.setTitle("title");
        eventDto.setDescription("description");
        eventDto.setStart(LocalDate.of(2020, 1, 1));
        eventDto.setFinish(LocalDate.of(2020, 1, 1));
        eventDto.setId(0L);

        // Configure EventRepository.findById(...).
        final Optional<Event> event = Optional.of(
                new Event(0L, "title", "description", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        when(mockEventRepository.findById(0L)).thenReturn(event);

        // Configure EventRepository.save(...).
        final Event event1 = new Event(0L, "title", "description", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1));
        when(mockEventRepository.save(any(Event.class))).thenReturn(event1);

        // Run the test
        final EventDto result = eventServiceUnderTest.updateEvent(eventDto, 0L);

        // Verify the results
        verify(mockEventRepository).save(any(Event.class));
    }

    @Test
    void testUpdateEvent_EventRepositoryFindByIdReturnsAbsent() {
        // Setup
        final EventDto eventDto = new EventDto();
        eventDto.setTitle("title");
        eventDto.setDescription("description");
        eventDto.setStart(LocalDate.of(2020, 1, 1));
        eventDto.setFinish(LocalDate.of(2020, 1, 1));
        eventDto.setId(0L);

        when(mockEventRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> eventServiceUnderTest.updateEvent(eventDto, 0L)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void testRemoveEvent() {
        // Setup
        // Run the test
        eventServiceUnderTest.removeEvent(0L);

        // Verify the results
        verify(mockEventRepository).deleteById(0L);
    }

    @Test
    void testGetEventsInRange() {
        // Setup
        // Configure EventRepository.findByStartGreaterThanEqualAndFinishLessThanEqual(...).
        final List<Event> events = List.of(
                new Event(0L, "title", "description", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        when(mockEventRepository.findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1))).thenReturn(events);

        // Run the test
        final List<EventDto> result = eventServiceUnderTest.getEventsInRange(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));

        // Verify the results
    }

    @Test
    void testGetEventsInRange_EventRepositoryReturnsNoItems() {
        // Setup
        when(mockEventRepository.findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1))).thenReturn(Collections.emptyList());

        // Run the test
        final List<EventDto> result = eventServiceUnderTest.getEventsInRange(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testFromDto() {
        // Setup
        final EventDto eventDto = new EventDto();
        eventDto.setTitle("title");
        eventDto.setDescription("description");
        eventDto.setStart(LocalDate.of(2020, 1, 1));
        eventDto.setFinish(LocalDate.of(2020, 1, 1));
        eventDto.setId(0L);

        // Run the test
        final Event result = eventServiceUnderTest.fromDto(eventDto);

        // Verify the results
    }

    @Test
    void testToDto() {
        // Setup
        final Event event = new Event(0L, "title", "description", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1));

        // Run the test
        final EventDto result = eventServiceUnderTest.toDto(event);

        // Verify the results
    }
}
