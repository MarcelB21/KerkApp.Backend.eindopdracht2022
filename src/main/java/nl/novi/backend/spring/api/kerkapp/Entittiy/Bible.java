package nl.novi.backend.spring.api.kerkapp.Entittiy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@Entity
public class Bible {

    @Column(name = "Book")
    private int Book;
    
    @Column(name = "Chapter")
    private int Chapter;
    
    @Column(name = "Verse")
    private int Verse;
    
    @Column(name = "Scripture")
    private String Scripture;

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

}
