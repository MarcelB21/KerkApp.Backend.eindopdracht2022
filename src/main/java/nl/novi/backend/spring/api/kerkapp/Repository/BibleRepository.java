package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BibleRepository extends JpaRepository<Bible, Long> {

    List<Bible> findByBooknameIgnoreCase(String bookname);

    Optional<Bible> findByBookAndChapterAndVerse(int book, int chapter, int verse);

    Optional<Bible> findByBooknameIgnoreCaseAndChapter(String bookname, int chapter);

    Optional<Bible> findByBooknameIgnoreCaseAndChapterAndVerse(String bookname, int chapter, int verse);

}
