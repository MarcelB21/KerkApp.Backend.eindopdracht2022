package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Creed;
import nl.novi.backend.spring.api.kerkapp.Repository.CreedRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreedService {

    private final CreedRespository creedRespository;

    public CreedService(CreedRespository creedRespository) {
        this.creedRespository = creedRespository;
    }

    public List<Creed> getAllLines(String line) {
        return creedRespository.findByLine(line);
    }

}
