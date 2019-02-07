package entity;

import java.util.ArrayList;
import java.util.List;

public class MockLibrary implements LibraryInterface {

    @Override
    public void setBooks(List<Book> books) {
        // do nothing
    }

    @Override
    public List<Book> getBooks() {

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

        List<Book> books = new ArrayList<>();
        books.add(designPatterns);
        books.add(cleanCode);
        books.add(theCleanCoder);

        return books;
    }
}
