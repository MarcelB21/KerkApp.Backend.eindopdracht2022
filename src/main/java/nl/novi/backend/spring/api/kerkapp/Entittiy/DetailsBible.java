package nl.novi.backend.spring.api.kerkapp.Entittiy;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DetailsBible {

    @Column(name = "Description")
    private String Description;

    @Column(name = "Abbreviation")
    private String Abbreviation;

    @Column(name = "Comment")
    private String Comment;

    @Column(name = "Version Number")
    private int version;
}
