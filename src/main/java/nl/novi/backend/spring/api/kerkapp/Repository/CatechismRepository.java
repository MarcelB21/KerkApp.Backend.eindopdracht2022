package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Catechism;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatechismRepository extends JpaRepository<Catechism, Long> {

    List<Catechism> findByZondag(int zondag);

    List<Catechism> findByDeel(int deel);

    List<Catechism> findByDeelAndZondag(int deel, int zondag);

}
