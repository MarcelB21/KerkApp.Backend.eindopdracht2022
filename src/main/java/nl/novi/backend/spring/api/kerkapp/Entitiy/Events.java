package nl.novi.backend.spring.api.kerkapp.Entitiy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="events", schema = "public")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ïd")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String Description;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "finish")
    private LocalDateTime finish;

    public Events() {
        super();
    }

    public Events(Long id, String title, String description, LocalDateTime start, LocalDateTime finish) {
        super();
        this.id = id;
        this.title = title;
        Description = description;
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
        return Description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Description='" + Description + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
