package entity;

import java.util.Date;

public class Book {

    private Integer id;
    private Integer copies;
    private String name;
    private String author;
    private Date launchDate;

    @Override
    public String toString() {
        return "[" + id + "]" + name + ", by " + author;
    }

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public Book setCopies(Integer copies) {
        this.copies = copies;
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

    public Date getLaunchDate() {
        return launchDate;
    }

    public Book setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
        return this;
    }
}
