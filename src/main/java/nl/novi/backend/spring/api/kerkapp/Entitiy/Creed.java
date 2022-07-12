package nl.novi.backend.spring.api.kerkapp.Entitiy;

import javax.persistence.*;

@Entity
@Table (name = "creed", schema = "public")
public class Creed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "line")
    private String line;

    public Creed(String line) {
        this.line = line;
    }

    public Creed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

}
