package entity;

public class Book {

    private Integer id;
    private String name;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "[" + id + "] " + name + " - " + author + ". (" + year + ")";
    }

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Book setYear(int year) {
        this.year = year;
        return this;
    }
}
