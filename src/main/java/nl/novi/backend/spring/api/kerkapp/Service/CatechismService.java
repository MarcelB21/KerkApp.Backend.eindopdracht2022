package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Catechism;
import nl.novi.backend.spring.api.kerkapp.Repository.CatechismRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatechismService {

    private CatechismRepository CatechismRepository;

    public CatechismService(CatechismRepository CatechismRepository) {
        this.CatechismRepository = CatechismRepository;
    }

    public List<Catechism> getAllCatechism() {
        List<Catechism> catechisms = CatechismRepository.findAll();
        return catechisms;
    }

    public List<Catechism> getByZondagCatechism(int zondag) {
        List<Catechism> catechisms = CatechismRepository.findByZondag(zondag);
        return catechisms;
    }

    public List<Catechism> getByDeelCatechism(int deel) {
        List<Catechism> catechisms = CatechismRepository.findByDeel(deel);
        return catechisms;
    }
}
