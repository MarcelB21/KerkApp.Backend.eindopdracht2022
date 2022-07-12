package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import nl.novi.backend.spring.api.kerkapp.Repository.BibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibleService {
   private final BibleRepository bibleRepository;

   @Autowired
   public BibleService(BibleRepository bibleRepository) {
      this.bibleRepository = bibleRepository;
   }

   public Optional<Bible> getScriptureById(Long id) {
      return bibleRepository.findById(id);
   }

   public List<Bible> getBibleBook(String bookname) {
      return bibleRepository.findByBooknameIgnoreCase(bookname);
   }

   public Optional<Bible> getByChapter(String bookname, int chapter) {
      return bibleRepository.findByBooknameIgnoreCaseAndChapter(bookname, chapter);
   }

   public Optional<Bible> getVersebybookname(String bookname, int chapter, int verse) {
      return bibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse(bookname, chapter, verse);
   }

   public Optional<Bible> getVerse(int book, int chapter, int verse) {
      return bibleRepository.findByBookAndChapterAndVerse(book, chapter, verse);
   }


}
