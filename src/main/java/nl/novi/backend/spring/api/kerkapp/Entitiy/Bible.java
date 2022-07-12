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
    public int book;

    @Column(name = "bookname")
    @Type(type = "text")
    public String bookname;

    @Column(name = "chapter")
    private int chapter;
    
    @Column(name = "verse")
    private int verse;
    
    @Column(name = "scripture")
    @Type(type = "text")
    private String scripture;

    public Bible(int book, int chapter, int verse, String scripture) {
        book = book;
        chapter = chapter;
        verse = verse;
        scripture = scripture;
    }

    public Long getId() {
        return id;
    }

    public int getBook() {
        return book;
    }

    public String getBookname() {
        return bookname;
    }

    public int getChapter() {
        return chapter;
    }

    public int getVerse() {
        return verse;
    }

    public String getScripture() {
        return scripture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(int book) {
        book = book;
    }

    public void setBookName(String bookname) {
        bookname = bookname;
    }


}
