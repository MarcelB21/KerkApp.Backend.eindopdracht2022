package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BibleRepository extends JpaRepository<Bible, Long> {

//    String findByBookNameAndChapterAndVerse();
//    Optional<String> findByBookNameAndChapterAndVerse(String bookName, int Chapter, int verse);
}
