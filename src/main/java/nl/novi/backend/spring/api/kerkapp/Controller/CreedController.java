package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Entitiy.ApologeticCreed;
import nl.novi.backend.spring.api.kerkapp.Service.CreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CreedController {

    private final CreedService Creedservice;

    @Autowired
    public CreedController(CreedService creedservice) {
        Creedservice = creedservice;
    }

    @GetMapping(value="/creed")
    public List<ApologeticCreed> getAllCreed() {
        return getAllCreed();
    }
}
