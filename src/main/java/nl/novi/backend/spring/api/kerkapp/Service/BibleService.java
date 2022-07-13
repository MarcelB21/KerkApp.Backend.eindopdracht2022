package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import nl.novi.backend.spring.api.kerkapp.Repository.BibleRepository;
import nl.novi.backend.spring.api.kerkapp.dto.BibleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BibleService {
   private final BibleRepository bibleRepository;

   @Autowired
   public BibleService(BibleRepository bibleRepository) {
      this.bibleRepository = bibleRepository;
   }

   public List<BibleDto> getBibleBook(String bookname) {
      List<Bible> bibles = bibleRepository.findByBooknameIgnoreCase(bookname);
      List<BibleDto> bibleDtos = new ArrayList<>();
      for (Bible bible: bibles) {
         bibleDtos.add(toDto(bible));
      }
      return bibleDtos;
   }

   public List<BibleDto> getByChapter(String bookname, int chapter) {
      List<Bible> bibles = bibleRepository.findByBooknameIgnoreCaseAndChapter(bookname, chapter);
      List<BibleDto> bibleDtos = new ArrayList<>();
      for (Bible bible: bibles) {
         bibleDtos.add(toDto(bible));
      }
      return bibleDtos;
   }


   public BibleDto getVersebybookname(String bookname, int chapter, int verse) {
      BibleDto bibleDto = toDto(bibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse(bookname, chapter, verse));
      return bibleDto;
   }


   public BibleDto toDto(Bible bible) {
      BibleDto bibleDto = new BibleDto();

      bibleDto.setVerse(bible.getBookname()+" "+String.valueOf(bible.getChapter())+":"+String.valueOf(bible.getVerse())+" "+bible.getScripture());
      return bibleDto;
   }
}
