package controller;

import entity.LibraryInterface;
import io.Presenter;

import java.io.PrintStream;

public class Biblioteca {

    private Presenter presenter;
    private LibraryInterface library;

    public Biblioteca(LibraryInterface library, PrintStream printStream) {
        this.presenter = new Presenter(printStream);
        this.library = library;
    }

    public void listBooks() {

        StringBuilder listOfBooks = new StringBuilder();

        library.getBooks().forEach(book -> {
            listOfBooks.append(book.toString() + "\n");
        });

        presenter.print(listOfBooks.toString());
    }
}
