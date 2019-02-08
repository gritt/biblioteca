package service;

import entity.Book;
import entity.Library;

import java.util.ArrayList;
import java.util.List;

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


    //TODO @gritt, remove getBooks from this class
    public static List<Book> getBooks() {

        List<Book> books = new ArrayList<>();

        Book designPatterns = new Book()
                .setName("Design Patterns, Elements of Reusable Object-Oriented-Software")
                .setAuthor("Erich Gama")
                .setYear(1994);

        Book cleanCode = new Book()
                .setName("Clean Code")
                .setAuthor("Robert C Martin")
                .setYear(2008);

        Book theCleanCoder = new Book()
                .setName("The Clean Coder")
                .setAuthor("Robert C Martin")
                .setYear(2011);

        Book commandLineKungFu = new Book()
                .setName("Command Line Kung Fu")
                .setAuthor("Jason Cannon")
                .setYear(2014);

        Book dataScienceFromScratch = new Book()
                .setName("Data Science From Scratch")
                .setAuthor("Joel Grus")
                .setYear(2015);

        Book pythonTheBible = new Book()
                .setName("Python, The Bible")
                .setAuthor("Maurice J. Thompson")
                .setYear(2018);

        books.add(designPatterns);
        books.add(cleanCode);
        books.add(theCleanCoder);
        books.add(commandLineKungFu);
        books.add(dataScienceFromScratch);
        books.add(pythonTheBible);

        return books;
    }
}
