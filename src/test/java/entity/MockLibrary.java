package entity;

import java.util.List;

public class MockLibrary implements LibraryInterface {

    @Override
    public void setBooks(List<Book> books) {
        // do nothing
    }

    @Override
    public List<Book> getBooks() {
        // return a list of fake books
        return  null;
    }
}
