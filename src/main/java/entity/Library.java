package entity;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<Book> reservedBooks = new ArrayList<>();


    public Library(List<Book> books) {
        this.books = books;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }


    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void removeReservedBook(Book book) {
        this.reservedBooks.remove(book);
    }

    public void addReservedBook(Book book) {
        this.reservedBooks.add(book);
    }
}
