package entity;

public class Book {

    private int id;
    private boolean available;
    private String name;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "[" + id + "]. " + name + " - " + author + ". " + year + "";
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public Book setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setYear(int year) {
        this.year = year;
        return this;
    }
}
