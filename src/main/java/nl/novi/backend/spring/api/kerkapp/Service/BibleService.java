package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import nl.novi.backend.spring.api.kerkapp.Entitiy.FileUploadResponse;
import nl.novi.backend.spring.api.kerkapp.Exception.RecordNotFoundException;
import nl.novi.backend.spring.api.kerkapp.Repository.BibleRepository;
import nl.novi.backend.spring.api.kerkapp.Repository.FileUploadRepository;
import nl.novi.backend.spring.api.kerkapp.dto.BibleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.valueOf;

@Service
public class BibleService {
   private final BibleRepository bibleRepository;
   private final FileUploadRepository uploadRepository;

   @Autowired
   public BibleService(BibleRepository bibleRepository, FileUploadRepository uploadRepository) {
      this.bibleRepository = bibleRepository;
      this.uploadRepository = uploadRepository;
   }

   public List<BibleDto> getVersesByBookname(String bookname) {
      List<Bible> bibles = bibleRepository.findByBooknameIgnoreCase(bookname);
      List<BibleDto> bibleDtos = new ArrayList<>();
      for (Bible bible: bibles) {
         bibleDtos.add(toDto(bible));
      }
      return bibleDtos;
   }

   public List<BibleDto> getVerseByBooknameChapter(String bookname, int chapter) {
      List<Bible> bibles = bibleRepository.findByBooknameIgnoreCaseAndChapter(bookname, chapter);
      List<BibleDto> bibleDtos = new ArrayList<>();
      for (Bible bible: bibles) {
         bibleDtos.add(toDto(bible));
      }
      return bibleDtos;
   }


   public BibleDto getVerseByBooknameChapterVerse(String bookname, int chapter, int verse) throws RecordNotFoundException {
      Optional<Bible> optionalBible= bibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse(bookname, chapter, verse);
      BibleDto bibleDto;
      if(optionalBible.isPresent()) {
         bibleDto = toDto(optionalBible.get());
         return bibleDto;
      } else {
         throw new RecordNotFoundException("Bibleverse not found");
      }
   }

   public String getByVerseBetweenVerse(String bookname, int chapter, int startverse, int endverse) {
      List<Bible> bibles = bibleRepository.findByBooknameIgnoreCaseAndChapter(bookname, chapter);
      StringBuilder stringBuilder = new StringBuilder(bookname.substring(0, 1).toUpperCase() + bookname.substring(1) + " " + chapter + "\n" + " ");
      for (Bible bible: bibles) {
         if(bible.getVerse()>=startverse && bible.getVerse()<=endverse) {
            stringBuilder.append(valueOf(bible.getVerse()) + " " + bible.getScripture());
         }
      }
      return stringBuilder.toString();
   }


   public BibleDto toDto(Bible bible) {
      BibleDto bibleDto = new BibleDto();

      bibleDto.setVerse(bible.getBookname()+" "+ valueOf(bible.getChapter())+":"+ valueOf(bible.getVerse())+" "+bible.getScripture());
      return bibleDto;
   }

   public void assignPhotoToBibleVerse(String bookname, int chapter, int verse, MultipartFile file) throws RecordNotFoundException {

      Optional<Bible> optionalBible =  bibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse(bookname, chapter, verse);
      if(optionalBible.isPresent()) {
         Bible bibleVerse = optionalBible.get();

         String filename = file.getOriginalFilename();
         Optional <FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(filename);

         if (fileUploadResponse.isPresent()) {

            FileUploadResponse photo = fileUploadResponse.get();

            bibleVerse.setFile(photo);

            bibleRepository.save(bibleVerse);

         } else {
            throw new RecordNotFoundException("Filename not found");
         }
      } else {
         throw new RecordNotFoundException("Bible verse not found");
      }
   }
}
