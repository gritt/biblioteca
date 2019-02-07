package service;

import entity.Book;
import entity.LibraryInterface;
import io.Reader;
import io.Writer;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Library {

    private Writer ioWriter;
    private Reader ioReader;
    private LibraryInterface library;

    private int bookId = -1;
    private int status;


    public Library(LibraryInterface library, PrintStream printStream, InputStream inputStream) {
        this.ioWriter = new Writer(printStream);
        this.ioReader = new Reader(inputStream);
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

        ioWriter.print(listOfBooks.toString());

        status = Menu.CONTINUE;
    }

    public void listReservedBooks() {

        StringBuilder listOfReservedBooks = new StringBuilder();

        library.getReservedBooks().forEach(book -> {
            listOfReservedBooks.append(book.toString() + "\n");
        });

        ioWriter.print(listOfReservedBooks.toString());

        status = Menu.CONTINUE;
    }


    public void checkoutBook() {
        try {

            while (!hasInformedBookId()) {
                bookId = readBookId();
            }

            Book book = library.getBooks().get(bookId);

            library.removeBook(book);
            library.addReservedBook(book);

        } catch (Exception ex) {
            //TODO @gritt, show error message if failed to checkout book
            return;
        }

        status = Menu.CONTINUE;
    }

    private boolean hasInformedBookId() {
        return bookId != -1;
    }

    private int readBookId () {
        listBooks();

        ioWriter.print("\nPlease choose a book from the list [number]: \n");

        return ioReader.readNumber();
    }

    public Library setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }



    public void close() {
        status = Menu.QUIT;
    }
}
