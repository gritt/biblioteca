package entity;

import java.util.List;

public interface LibraryInterface {

    public void setBooks(List<Book> books);

    public List<Book> getBooks();

    public List<Book> getReservedBooks();

    public void removeBook(Book book);

    public void addBook(Book book);

    public void removeReservedBook(Book book);

    public void addReservedBook(Book book);
}
