package service;

import entity.Book;
import entity.Library;

public class LibraryService {

    private Library library;


    public Library getLibrary() {
        return library;
    }

    public LibraryService setLibrary(Library library) {
        this.library = library;
        return this;
    }


    public String listBooks() {

        StringBuilder listOfBooks = new StringBuilder();

        for (int i = 0; i < library.getBooks().size(); i++) {
            listOfBooks.append("[" + i + "]. " + library.getBooks().get(i).toString() + "\n");
        }

        return listOfBooks.toString();
    }

    public String listReservations() {

        StringBuilder listOfReservedBooks = new StringBuilder();

        for (int i = 0; i < library.getReservations().size(); i++) {
            listOfReservedBooks.append("[" + i + "]. " + library.getReservations().get(i).toString() + "\n");
        }

        return listOfReservedBooks.toString();
    }

    public boolean checkoutBook(int bookId) {
        try {

            Book targetBook = library.getBooks().get(bookId);
            library.removeBook(targetBook);
            library.addReservation(targetBook);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean returnBook(int bookId) {
        try {

            Book targetBook = library.getReservations().get(bookId);
            library.removeReservation(targetBook);
            library.addBook(targetBook);

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
