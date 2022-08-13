package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
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
    public ResponseEntity<List<BibleDto>> getByBibleBook(@PathVariable String bookname) throws RecordNotFoundException {
        List<BibleDto> foundBooks = bibleService.getVersesByBookname(bookname);
        return ResponseEntity.ok().body(foundBooks);
    }

    @GetMapping("/Bible/{bookname}/{chapter}")
    public ResponseEntity<BibleDto> getByChapter(@PathVariable String bookname, @PathVariable int chapter) {
        BibleDto foundChapter = bibleService.getVerseByBooknameChapter(bookname, chapter);
        return ResponseEntity.ok().body(foundChapter);
    }

    @GetMapping("/Bible/{bookname}/{chapter}/{verse}")
    public ResponseEntity<BibleDto> getVersebybookname(@PathVariable(value = "bookname") String bookname, @PathVariable int chapter, @PathVariable int verse) throws RecordNotFoundException {
        BibleDto TGfoundVerse = bibleService.getVerseByBooknameChapterVerse(bookname, chapter, verse);
        return ResponseEntity.ok().body(TGfoundVerse);
    }

    @PostMapping("/Bible/{bookname}/{chapter}/{verse}/photo")
    public ResponseEntity<FileUploadResponse> assignPhotoToBibleVerse(@PathVariable(value = "bookname") String bookname, @PathVariable int chapter, @PathVariable int verse, @RequestBody MultipartFile file) throws RecordNotFoundException {
        FileUploadResponse photo = controller.singleFileUpload(file);

        bibleService.assignPhotoToBibleVerse(bookname, chapter, verse, file);
        return ResponseEntity.ok(photo);
    }

    @GetMapping("/Bible")
    public ResponseEntity<BibleDto> getByVerseBetweenVerse(@RequestParam (value = "bookname", required = false) String bookname, @RequestParam (value = "chapter", required = false) int chapter, @RequestParam (value = "start", required = false) int start, @RequestParam (value = "end", required = false) int end) {
        BibleDto bibleDto = bibleService.getByVerseBetweenVerse(bookname, chapter, start, end);
        return ResponseEntity.ok().body(bibleDto);
    }

    @GetMapping("/Bible/keyword/{keyword}")
    public ResponseEntity<List<Bible>> getByKeyword(@PathVariable String keyword) {
        List<Bible> foundBooks = bibleService.getVersesByKeyword(keyword);
        return ResponseEntity.ok().body(foundBooks);
    }
}
