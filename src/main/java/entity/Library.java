package entity;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<Book> reservations = new ArrayList<>();

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

    public List<Book> getReservations() {
        return reservations;
    }

    public void removeReservation(Book book) {
        reservations.remove(book);
    }

    public void addReservation(Book book) {
        reservations.add(book);
    }
}
