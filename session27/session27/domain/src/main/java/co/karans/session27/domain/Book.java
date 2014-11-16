package co.karans.session27.domain;

import javax.persistence.*;

@Entity
@Table(name = "book", schema = "public")
public class Book {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name", length = 512, nullable = false)
    private String name;
    @Column(name = "publish_year", nullable = true)
    private Integer publishYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Book) {
            return id == ((Book) obj).getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }
}
