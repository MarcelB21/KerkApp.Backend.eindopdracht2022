package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> deleteByUsername(String username);

    boolean existsByUsername(String username);



}
