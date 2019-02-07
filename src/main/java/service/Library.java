package service;

import entity.LibraryInterface;
import io.Writer;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Library {

    private Writer writer;
    private LibraryInterface library;
    private int status;

    public Library(LibraryInterface library, PrintStream printStream) {
        this.writer = new Writer(printStream);
        this.library = library;
    }

    public int execute(String method) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Method methodReflection;
        methodReflection = this.getClass().getMethod(method);
        methodReflection.invoke(this);

        return status;
    }

    public void listBooks() {

        StringBuilder listOfBooks = new StringBuilder();

        library.getBooks().forEach(book -> {
            listOfBooks.append(book.toString() + "\n");
        });

        writer.print(listOfBooks.toString());

        status = Menu.CONTINUE;
    }
}
