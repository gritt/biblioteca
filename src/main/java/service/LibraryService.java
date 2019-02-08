package service;

import entity.Book;
import entity.Library;

public class LibraryService {

    private Library library;

    public LibraryService setLibrary(Library library) {
        this.library = library;
        return this;
    }

    public String listBooks() {

        StringBuilder listOfBooks = new StringBuilder();

        library.getBooks().forEach((integer, book) -> {
            if (book.isAvailable()) {
                listOfBooks.append(book.toString() + "\n");
            }
        });


        return listOfBooks.toString();
    }

    public String listReservations() {

        StringBuilder listOfReservations = new StringBuilder();

        library.getBooks().forEach((integer, book) -> {
            if (!book.isAvailable()) {
                listOfReservations.append(book.toString() + "\n");
            }
        });

        return listOfReservations.toString();
    }

    public boolean checkoutBook(int bookId) {

        if (!library.getBooks().containsKey(bookId)) {
            return false;
        }

        Book targetBook = library.getBooks().get(bookId);

        if (!targetBook.isAvailable()) {
            return false;
        }

        targetBook.setAvailable(false);
        return true;
    }

    public boolean returnBook(int bookId) {

        if (!library.getBooks().containsKey(bookId)) {
            return false;
        }

        Book targetBook = library.getBooks().get(bookId);

        if (targetBook.isAvailable()) {
            return false;
        }

        targetBook.setAvailable(true);
        return true;
    }
}
