package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.ApologeticCreed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreedRespository extends JpaRepository<ApologeticCreed, Long> {
}
