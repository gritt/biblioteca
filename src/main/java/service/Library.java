package service;

import entity.LibraryInterface;
import io.Writer;

import java.io.PrintStream;

public class Library {

    private Writer writer;
    private LibraryInterface library;

    public Library(LibraryInterface library, PrintStream printStream) {
        this.writer = new Writer(printStream);
        this.library = library;
    }

    public int execute(String method) {

        System.out.println("do something");
        System.out.println(method);

        return -1;
    }

    public void listBooks() {

        StringBuilder listOfBooks = new StringBuilder();

        library.getBooks().forEach(book -> {
            listOfBooks.append(book.toString() + "\n");
        });

        writer.print(listOfBooks.toString());
    }
}
