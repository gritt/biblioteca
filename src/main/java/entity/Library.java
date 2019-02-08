package entity;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<Integer, Book> books = new HashMap<Integer, Book>();

    public Library(Map<Integer, Book> books) {
        this.books = books;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }
}
