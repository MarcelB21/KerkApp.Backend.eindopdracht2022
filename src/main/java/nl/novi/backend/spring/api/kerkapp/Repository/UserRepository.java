package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findById(String name);

    boolean existsById(String name);

    User save(User name);

    User deleteById(String username);
}
