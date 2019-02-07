package entity;

import java.util.ArrayList;
import java.util.List;

public class MockEmptyLibrary implements LibraryInterface {

    @Override
    public void setBooks(List<Book> books) {

    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        return books;
    }

    @Override
    public List<Book> getReservedBooks() {
        List<Book> books = new ArrayList<>();
        return books;
    }

    @Override
    public void removeBook(Book book) {

    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void removeReservedBook(Book book) {

    }

    @Override
    public void addReservedBook(Book book) {

    }
}
