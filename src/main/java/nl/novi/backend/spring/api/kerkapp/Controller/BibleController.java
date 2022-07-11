package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Catechism;
import nl.novi.backend.spring.api.kerkapp.Service.BibleService;
import nl.novi.backend.spring.api.kerkapp.Service.CatechismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

//    @GetMapping("/Catechisms")
//    public ResponseEntity<List<Catechism>> getByZondagCatechism(@RequestParam (value = "zondag", required = false) int zondag) {
//        List<Catechism> catechisms = bibleService.getByZondagCatechism(zondag);
//        return ResponseEntity.ok().body(catechisms);
//    }
//
//    @GetMapping("/Catechisms/{deel}")
//    public ResponseEntity<List<Catechism>> getByDeelCatechism(@PathVariable (value = "deel", required = false) int deel) {
//        List<Catechism> catechisms = bibleService.getByDeelCatechism(deel);
//        return ResponseEntity.ok().body(catechisms);
//    }
//

//    @GetMapping("/Bible/{bookName}/{Chapter}/{Verse}")
//    public ResponseEntity <Optional<String>> getVerse(@PathVariable (value = "bookName", required = true) String bookName, @PathVariable(value = "chapter", required = true) int chapter, @PathVariable(value = "verse", required = true) int verse) {
//        Optional<String> foundVerse = bibleService.getVerse(bookName, chapter, verse);
//        return ResponseEntity.ok().body(foundVerse);
//    }
}
