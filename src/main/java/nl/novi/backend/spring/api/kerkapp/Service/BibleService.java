package nl.novi.backend.spring.api.kerkapp.Service;

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

//   public Optional<String> getVerse(String bookName, int Chapter, int verse) {
//       return bibleRepository.findByBookNameAndChapterAndVerse(bookName, Chapter, verse);
//    }

//    public List<Catechism> getByZondagCatechism(int zondag) {
//        List<Catechism> catechisms = bibleRepository.findByZondag(zondag);
//        return catechisms;
//    }
//
//    public List<Catechism> getByDeelCatechism(int deel) {
//        List<Catechism> catechisms = bibleRepository.findByDeel(deel);
//        return catechisms;
//    }
//
//    public List<Catechism> findByDeelAndZondag(int deel, int zondag) {
//        List<Catechism> catechisms = bibleRepository.findByDeelAndZondag(deel, zondag);
//        return catechisms;
//    }
}
