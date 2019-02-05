package entity;

import java.util.List;

public class Library implements LibraryInterface {

    private List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
