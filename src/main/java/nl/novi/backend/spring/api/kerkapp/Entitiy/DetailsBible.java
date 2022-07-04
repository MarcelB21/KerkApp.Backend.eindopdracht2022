package nl.novi.backend.spring.api.kerkapp.Entitiy;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "details_bible", schema = "public")
public class DetailsBible {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Description")
    @Type(type = "text")
    private String Description;

    @Column(name = "Abbreviation")
    @Type(type = "text")
    private String Abbreviation;

    @Column(name = "Comment")
    @Type(type = "text")
    private String Comment;

    @Column(name = "Version")
    private int Version;

    public String getDescription() {
        return Description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
