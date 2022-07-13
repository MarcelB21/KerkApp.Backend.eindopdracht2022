package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import nl.novi.backend.spring.api.kerkapp.Service.BibleService;
import nl.novi.backend.spring.api.kerkapp.dto.BibleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BibleController {
    private final BibleService bibleService;

    @Autowired
    public BibleController(BibleService bibleService) {
        this.bibleService = bibleService;
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
    public ResponseEntity<BibleDto> getVersebybookname(@PathVariable(value = "bookname") String bookname, @PathVariable int chapter, @PathVariable int verse) {
        BibleDto TGfoundVerse = bibleService.getVersebybookname(bookname, chapter, verse);
        return ResponseEntity.ok().body(TGfoundVerse);
    }

}
