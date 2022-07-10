package nl.novi.backend.spring.api.kerkapp.Entitiy;

import javax.persistence.*;

@Entity
@Table(name = "hc", schema = "public")
public class Catechism {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ïd")
    private Long id;

    @Column(name = "Deel")
    private int deel;

    @Column(name = "zondag")
    private int zondag;

    @Column(name = "vraag")
    private String vraag;

    @Column(name = "antwoord")
    private String antwoord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDeel() {
        return deel;
    }

    public void setDeel(int deel) {
        this.deel = deel;
    }

    public int getZondag() {
        return zondag;
    }

    public void setZondag(int zondag) {
        this.zondag = zondag;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    public Catechism(int deel, int zondag, String vraag, String antwoord) {
        this.deel = deel;
        this.zondag = zondag;
        this.vraag = vraag;
        this.antwoord = antwoord;
    }
}
