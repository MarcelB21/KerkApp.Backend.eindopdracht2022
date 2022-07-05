package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventJpaRepository extends JpaRepository<Events, Long> {
    List<Events> findAll();
    Events save(Events events);
    void delete(Events events);

    public List<Events> findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDateTime start, LocalDateTime end);

}
