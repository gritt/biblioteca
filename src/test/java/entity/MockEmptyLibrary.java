package entity;

import java.util.ArrayList;
import java.util.List;

public class MockEmptyLibrary implements LibraryInterface {

    @Override
    public void setBooks(List<Book> books) {
        // do nothing
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        return books;
    }

    @Override
    public List<Book> getReservedBooks() {
        return null;
    }
}
