package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDate start, LocalDate finish);

}
