package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Catechism;
import nl.novi.backend.spring.api.kerkapp.Service.CatechismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatechismController {

    private final CatechismService catechismService;

    @Autowired
    public CatechismController(CatechismService catechismService) {
        this.catechismService = catechismService;
    }

    @GetMapping("/Catechism")
    public ResponseEntity<List<Catechism>> getCatechism() {
        List<Catechism> catechismList = catechismService.getAllCatechism();
        return ResponseEntity.ok().body(catechismList);
    }

    @GetMapping("/Catechisms")
    public ResponseEntity<List<Catechism>> getByZondagCatechism(@RequestParam (value = "zondag", required = false) int zondag) {
        List<Catechism> catechisms = catechismService.getByZondagCatechism(zondag);
        return ResponseEntity.ok().body(catechisms);
    }

    @GetMapping("/Catechisms/{deel}")
    public ResponseEntity<List<Catechism>> getByDeelCatechism(@PathVariable (value = "deel", required = false) int deel) {
        List<Catechism> catechisms = catechismService.getByDeelCatechism(deel);
        return ResponseEntity.ok().body(catechisms);
    }

    @GetMapping("/Catechisms/{deel}/{zondag}")
    public ResponseEntity<List<Catechism>> getByDeelCatechism(@PathVariable (value = "deel", required = false) int deel, @PathVariable(value = "zondag", required = false) int zondag) {
        List<Catechism> catechisms = catechismService.findByDeelAndZondag(deel, zondag);
        return ResponseEntity.ok().body(catechisms);
    }
}
