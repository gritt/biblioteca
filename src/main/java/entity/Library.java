package entity;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryInterface {

    private List<Book> books = new ArrayList<>();

    private List<Book> reservedBooks = new ArrayList<>();

    public Library() {
        /*
         * fixed list of books
         */
        Book designPatterns = new Book()
                .setId(0)
                .setName("Design Patterns, Elements of Reusable Object-Oriented-Software")
                .setAuthor("Erich Gama")
                .setYear(1994);

        Book cleanCode = new Book()
                .setId(1)
                .setName("Clean Code")
                .setAuthor("Robert C Martin")
                .setYear(2008);

        Book theCleanCoder = new Book()
                .setId(2)
                .setName("The Clean Coder")
                .setAuthor("Robert C Martin")
                .setYear(2011);

        Book commandLineKungFu = new Book()
                .setId(3)
                .setName("Command Line Kung Fu")
                .setAuthor("Jason Cannon")
                .setYear(2014);

        Book dataScienceFromScratch = new Book()
                .setId(4)
                .setName("Data Science From Scratch")
                .setAuthor("Joel Grus")
                .setYear(2015);

        Book pythonTheBible = new Book()
                .setId(5)
                .setName("Python, The Bible")
                .setAuthor("Maurice J. Thompson")
                .setYear(2018);

        books.add(designPatterns);
        books.add(cleanCode);
        books.add(theCleanCoder);
        books.add(commandLineKungFu);
        books.add(dataScienceFromScratch);
        books.add(pythonTheBible);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void checkoutBook(Book book) {
        books.remove(book);
        reservedBooks.add(book);
    }
}
