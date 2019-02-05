package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library implements LibraryInterface {

    private List<Book> books;

    public Library() {
        /*
         * fixed list of books
         */
        Book designPatterns = new Book()
                .setId(1)
                .setName("Design Patterns, Elements of Reusable Object-Oriented-Software")
                .setAuthor("Erich Gama")
                .setCopies(10)
                .setLaunchDate(new Date());

        Book cleanCode = new Book()
                .setId(2)
                .setName("Clean Code")
                .setAuthor("Robert C Martin")
                .setCopies(5)
                .setLaunchDate(new Date());

        Book theCleanCoder = new Book()
                .setId(3)
                .setName("The Clean Coder")
                .setAuthor("Robert C Martin")
                .setCopies(3)
                .setLaunchDate(new Date());

        Book commandLineKungFu = new Book()
                .setId(4)
                .setName("Command Line Kung Fu")
                .setAuthor("Jason Cannon")
                .setCopies(5)
                .setLaunchDate(new Date());

        Book dataScienceFromScratch = new Book()
                .setId(5)
                .setName("Data Science From Scratch")
                .setAuthor("Joel Grus")
                .setCopies(10)
                .setLaunchDate(new Date());

        Book pythonTheBible = new Book()
                .setId(6)
                .setName("Python, The Bible")
                .setAuthor("Maurice J. Thompson")
                .setCopies(10)
                .setLaunchDate(new Date());

        List<Book> books = new ArrayList<>();
        books.add(designPatterns);
        books.add(cleanCode);
        books.add(theCleanCoder);
        books.add(commandLineKungFu);
        books.add(dataScienceFromScratch);
        books.add(pythonTheBible);

        this.books = books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
