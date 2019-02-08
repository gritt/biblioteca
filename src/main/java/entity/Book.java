package entity;

public class Book {

    private String name;
    private String author;
    private int year;


    @Override
    public String toString() {
        return name + " - " + author + ". " + year + "";
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
