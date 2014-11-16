package co.karans.session26.ejbs;

public class Book {
    private long id;
    private String name;
    private Integer publishYear;

    public Book() {
    }

    public Book(String name, Integer publishYear) {
        this.name = name;
        this.publishYear = publishYear;
    }

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
}
