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
      int amountChapters = bibles.get(bibles.size() - 1).getChapter();
      List<BibleDto> bibleDtos = new ArrayList<>();
      for (int i = 1; i <= amountChapters; i++) {
         List<String> lines = new ArrayList<>();
         List<FileUploadResponse> files = new ArrayList<>();
         for (Bible bible : bibles) {
            if (bible.getChapter() == i) {
               String string = (valueOf(bible.getVerse()) + " " + bible.getScripture());
               lines.add(string);
               FileUploadResponse file = bible.getFile();
               files.add(file);
            }
         }
         bibleDtos.add(toDto(bookname, i, lines, files));
      }
      return bibleDtos;
   }


   public BibleDto getVerseByBooknameChapter(String bookname, int chapter) {
      List<Bible> bibles = bibleRepository.findByBooknameIgnoreCaseAndChapter(bookname, chapter);
      List<String> lines = new ArrayList<>();
      List<FileUploadResponse> files = new ArrayList<>();
      for (Bible bible : bibles) {
            String string = (valueOf(bible.getVerse()) + " " + bible.getScripture());
            lines.add(string);
            FileUploadResponse file = bible.getFile();
            files.add(file);
      }
      return toDto(bookname, chapter, lines, files);
   }


   public BibleDto getVerseByBooknameChapterVerse(String bookname, int chapter, int verse) throws RecordNotFoundException {
      Optional<Bible> optionalBible = bibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse(bookname, chapter, verse);
      List<FileUploadResponse> files = new ArrayList<>();
      if (optionalBible.isPresent()) {
         String string = (verse + " " + optionalBible.get().getScripture());
         List<String> verseList = new ArrayList<>();
         verseList.add(string);
         FileUploadResponse file = optionalBible.get().getFile();
         files.add(file);
         return toDto(bookname, chapter, verseList, files);
      } else {
         throw new RecordNotFoundException("Bibleverse not found");
      }
   }


   public BibleDto getByVerseBetweenVerse(String bookname, int chapter, int startverse, int endverse) {
      List<Bible> bibles = bibleRepository.findByBooknameIgnoreCaseAndChapter(bookname, chapter);
      List<String> lines = new ArrayList<>();
      List<FileUploadResponse> files = new ArrayList<>();
      for (Bible bible : bibles) {
         if (bible.getVerse() >= startverse && bible.getVerse() <= endverse) {
            String string = (valueOf(bible.getVerse()) + " " + bible.getScripture());
            lines.add(string);
            FileUploadResponse file = bible.getFile();
            files.add(file);
         }
      }
      return toDto(bookname, chapter, lines, files);
   }

   public BibleDto toDto(String bookname, int chapter, List<String> verse, List<FileUploadResponse> files) {
      BibleDto bibleDto = new BibleDto();
      bibleDto.setTitle(bookname + " " + valueOf(chapter) + ":" + verse.get(0).substring(0, 3).replaceAll("[^0-9]", "") + " - " + verse.get(verse.size() - 1).substring(0, 3).replaceAll("[^0-9]", ""));
      bibleDto.setVerse(verse);
      bibleDto.setFiles(files);
      return bibleDto;
   }

   public void assignPhotoToBibleVerse(String bookname, int chapter, int verse, MultipartFile file) throws RecordNotFoundException {

      Optional<Bible> optionalBible = bibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse(bookname, chapter, verse);
      if (optionalBible.isPresent()) {
         Bible bibleVerse = optionalBible.get();

         String filename = file.getOriginalFilename();
         Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(filename);

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

   public List<Bible> getVersesByKeyword(String keyword) {
      List<Bible> bibles = bibleRepository.findByScriptureContainingIgnoreCase(keyword);

      return bibles;
   }

}
