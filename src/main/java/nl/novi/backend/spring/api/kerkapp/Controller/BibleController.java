package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.FileUploadResponse;
import nl.novi.backend.spring.api.kerkapp.Exception.RecordNotFoundException;
import nl.novi.backend.spring.api.kerkapp.Service.BibleService;
import nl.novi.backend.spring.api.kerkapp.dto.BibleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class BibleController {
    private final BibleService bibleService;
    private final PhotoController controller;

    @Autowired
    public BibleController(BibleService bibleService, PhotoController controller) {
        this.bibleService = bibleService;
        this.controller = controller;
    }

    @GetMapping("/Bible/{bookname}")
    public ResponseEntity<List<BibleDto>> getByBibleBook(@PathVariable String bookname) {
        List<BibleDto> foundBooks = bibleService.getBibleBook(bookname);
        return ResponseEntity.ok().body(foundBooks);
    }

    @GetMapping("/Bible/{bookname}/{chapter}")
    public ResponseEntity<List<BibleDto>> getByChapter(@PathVariable String bookname, @PathVariable int chapter) {
        List<BibleDto> foundChapter = bibleService.getByChapter(bookname, chapter);
        return ResponseEntity.ok().body(foundChapter);
    }

    @GetMapping("/Bible/{bookname}/{chapter}/{verse}")
    public ResponseEntity<BibleDto> getVersebybookname(@PathVariable(value = "bookname") String bookname, @PathVariable int chapter, @PathVariable int verse) throws RecordNotFoundException {
        BibleDto TGfoundVerse = bibleService.getVersebybookname(bookname, chapter, verse);
        return ResponseEntity.ok().body(TGfoundVerse);
    }

    @PostMapping("/Bible/{bookname}/{chapter}/{verse}/photo")
    public void assignPhotoToBibleVerse(@PathVariable(value = "bookname") String bookname, @PathVariable int chapter, @PathVariable int verse, @RequestBody MultipartFile file) throws RecordNotFoundException {
        FileUploadResponse photo = controller.singleFileUpload(file);

        bibleService.assignPhotoToBibleVerse(bookname, chapter, verse, file);
    }

}
