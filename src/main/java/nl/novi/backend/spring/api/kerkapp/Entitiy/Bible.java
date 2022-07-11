package nl.novi.backend.spring.api.kerkapp.Entitiy;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "bible", schema = "public")
public class Bible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "book")
    public int Book;

    @Column(name = "bookname")
    @Type(type = "text")
    public String BookName;

    @Column(name = "chapter")
    private int Chapter;
    
    @Column(name = "verse")
    private int Verse;
    
    @Column(name = "scripture")
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

    public int getBook() {
        return Book;
    }

    public String getBookName() {
        return BookName;
    }

    public int getChapter() {
        return Chapter;
    }

    public int getVerse() {
        return Verse;
    }

    public String getScripture() {
        return Scripture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(int book) {
        Book = book;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }


}
