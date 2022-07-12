package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import nl.novi.backend.spring.api.kerkapp.Service.BibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BibleController {
    private final BibleService bibleService;

    @Autowired
    public BibleController(BibleService bibleService) {
        this.bibleService = bibleService;
    }

    @GetMapping("/Bible/{id}")
    public ResponseEntity<Optional<Bible>> getSciptureById(@PathVariable Long id) {
        Optional<Bible> foundVerse = bibleService.getScriptureById(id);
        return ResponseEntity.ok().body(foundVerse);
    }

    @GetMapping("/Bible/{bookname}")
    public ResponseEntity<Optional<Bible>> getByBibleBook(@PathVariable String bookname) {
        Optional<Bible> foundBook = bibleService.getBibleBook(bookname);
        return ResponseEntity.ok().body(foundBook);
    }

    @GetMapping("/Bible/{bookname}/{chapter}")
    public ResponseEntity<Optional<Bible>> getByChapter(@PathVariable String bookname, @PathVariable int chapter) {
        Optional<Bible> foundChapter = bibleService.getByChapter(bookname, chapter);
        return ResponseEntity.ok().body(foundChapter);
    }

    @GetMapping("/Bible/{book}/{chapter}/{verse}")
    public ResponseEntity<Optional<Bible>> getVerse(@PathVariable int book, @PathVariable int chapter, @PathVariable int verse) {
        Optional<Bible> TGfoundVerse = bibleService.getVerse(book, chapter, verse);
        return ResponseEntity.ok().body(TGfoundVerse);
    }

    @GetMapping("/Bible/{bookname}/{chapter}/{verse}")
    public ResponseEntity<Optional<Bible>> getVersebybookname(@PathVariable(value = "bookname") String bookname, @PathVariable int chapter, @PathVariable int verse) {
        Optional<Bible> TGfoundVerse = bibleService.getVersebybookname(bookname, chapter, verse);
        return ResponseEntity.ok().body(TGfoundVerse);
    }

}
