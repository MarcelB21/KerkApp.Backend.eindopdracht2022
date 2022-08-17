package nl.novi.backend.spring.api.kerkapp.Entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="events", schema = "public")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ïd")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start", nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate start;

    @Column(name = "finish", nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate finish;

    public Event() {
        super();
    }

    public Event(Long id, String title, String description, LocalDate start, LocalDate finish) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.finish = finish;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Description='" + description + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
