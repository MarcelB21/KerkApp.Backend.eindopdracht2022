package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BibleRepository extends JpaRepository<Bible, Long> {

    List<Bible> getByBooknameIgnoreCase(String bookname);

    boolean existsByBooknameIgnoreCase(String bookname);

    Bible findByBookAndChapterAndVerse(int book, int chapter, int verse);

    List<Bible> findByBooknameIgnoreCaseAndChapter(String bookname, int chapter);

//    Bible findByBooknameIgnoreCaseAndChapterAndVerse(String bookname, int chapter, int verse);

    List<Bible> findByScriptureContainingIgnoreCase(String keyword);

    Optional<Bible> findByBooknameIgnoreCaseAndChapterAndVerse(@Param("bookname")String bookname, @Param("chapter")int chapter, @Param("verse")int verse);

}
