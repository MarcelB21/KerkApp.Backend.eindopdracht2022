package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Catechism;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatechismRepository extends JpaRepository<Catechism, Long> {
}
