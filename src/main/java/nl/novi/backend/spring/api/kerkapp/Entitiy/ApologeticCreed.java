package nl.novi.backend.spring.api.kerkapp.Entitiy;

import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@Table(name="Creed", schema = "public")
public class ApologeticCreed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ApologeticCreed(String text) {
        this.text = text;
    }
}
