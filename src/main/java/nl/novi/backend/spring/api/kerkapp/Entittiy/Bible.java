package nl.novi.backend.spring.api.kerkapp.Entittiy;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "bible", schema = "public")
public class Bible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Book")
    private int Book;
    
    @Column(name = "Chapter")
    private int Chapter;
    
    @Column(name = "Verse")
    private int Verse;
    
    @Column(name = "Scripture")
    @Type(type = "text")
    private String Scripture;

    public Bible(int book, int chapter, int verse, String scripture) {
        Book = book;
        Chapter = chapter;
        Verse = verse;
        Scripture = scripture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
