package tutorial.core.models.entities;

import javax.persistence.*;

/**
 * Created by Chris on 6/28/14.
 */
@Entity
public class Blog {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToOne(fetch=FetchType.LAZY)
    private Account owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title +'}';
    }
}
