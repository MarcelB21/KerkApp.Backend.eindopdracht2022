package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Creed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreedRespository extends JpaRepository<Creed, Long> {

}
