package ch.keepcalm.web.sba.domain;

import javax.persistence.*;

/**
 * Created by marcelwidmer on 02/06/15.
 */
@Entity
@Table(name="LoggingStore")
public class LoggingStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", nullable = true, length = 500)
    private String description;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Version
    private long version;

    public LoggingStore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
