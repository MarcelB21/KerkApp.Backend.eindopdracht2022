package nl.novi.backend.spring.api.kerkapp.Entitiy;

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

    @Column(name = "bookname", length = 2048)
    public String bookname;

    @Column(name = "chapter")
    private int chapter;
    
    @Column(name = "verse")
    private int verse;
    
    @Column(name = "scripture", length = 2048)
    private String scripture;

    @ManyToOne
    @JoinColumn(name = "file_ID")
    FileUploadResponse file;

    public Bible(int book, int chapter, int verse, String scripture, String bookname) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
        this.scripture = scripture;
        this.bookname = "";
    }

    public Bible() {
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

    public void setFile(FileUploadResponse file) {
        this.file = file;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public void setVerse(int verse) {
        this.verse = verse;
    }

    public void setScripture(String scripture) {
        this.scripture = scripture;
    }

    public FileUploadResponse getFile() {
        return file;
    }
}
