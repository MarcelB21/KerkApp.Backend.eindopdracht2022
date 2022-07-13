package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Creed;
import nl.novi.backend.spring.api.kerkapp.Repository.CreedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreedService {

    private final CreedRepository creedRepository;

    public CreedService(CreedRepository creedRepository) {
        this.creedRepository = creedRepository;
    }

    public List<Creed> getAllCreed() {
        return creedRepository.findAll();
    }

}
