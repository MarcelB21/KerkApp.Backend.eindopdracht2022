package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Creed;
import nl.novi.backend.spring.api.kerkapp.Service.CreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreedController {

    private final CreedService creedservice;

    @Autowired
    public CreedController( CreedService creedservice) {
        this.creedservice = creedservice;
    }

    @GetMapping(value="/creed")
    public ResponseEntity<List<Creed>> getAllCreed() {
        List<Creed> getAllCreed = creedservice.getAllCreed();
        return ResponseEntity.ok().body(getAllCreed);
    }

}
