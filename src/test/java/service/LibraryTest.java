package service;

import entity.Book;
import entity.LibraryInterface;
import entity.MockEmptyLibrary;
import io.FakePrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class LibraryTest {

    private LibraryInterface mockLibrary;

    @BeforeEach
    public void setupMockLibrary() {
        List<Book> fakeBooks = new ArrayList<>();

        Book designPatterns = new Book()
                .setId(0)
                .setName("Book A")
                .setAuthor("Erich Gama")
                .setYear(1994);

        Book cleanCode = new Book()
                .setId(1)
                .setName("Book B")
                .setAuthor("Robert C Martin")
                .setYear(2008);

        fakeBooks.add(designPatterns);
        fakeBooks.add(cleanCode);

        mockLibrary = new entity.Library(fakeBooks);


        Book theCleanCoder = new Book()
                .setId(2)
                .setName("Book C")
                .setAuthor("Robert C Martin")
                .setYear(2011);

        mockLibrary.addReservedBook(theCleanCoder);
    }

    @Test
    public void shouldListBooks() {

        FakePrintStream printStream = new FakePrintStream();
        Library library = new Library(mockLibrary, printStream, System.in);

        library.listBooks();

        assertThat(printStream.printedString(), is(
                "[0] Book A - Erich Gama. (1994)\n" +
                        "[1] Book B - Robert C Martin. (2008)\n"
        ));
    }

    @Test
    public void shouldListEmptyWhenThereAreNoBooks() {

        FakePrintStream printStream = new FakePrintStream();
        Library library = new Library(new MockEmptyLibrary(), printStream, System.in);

        library.listBooks();

        assertThat(printStream.printedString(), is(""));
    }

    @Test
    public void shouldListReservedBooks() {
        FakePrintStream printStream = new FakePrintStream();
        Library library = new Library(mockLibrary, printStream, System.in);

        library.listReservedBooks();

        assertThat(printStream.printedString(), is("[2] Book C - Robert C Martin. (2011)\n"));
    }

    @Test
    public void shouldCheckoutBook() {
        FakePrintStream printStream = new FakePrintStream();
        Library library = new Library(mockLibrary, printStream, System.in);

        library.setBookId(0);
        library.checkoutBook();
        library.listReservedBooks();

        assertThat(printStream.printedString(), is(
                "[2] Book C - Robert C Martin. (2011)\n" +
                        "[0] Book A - Erich Gama. (1994)\n"

        ));
    }

    @Test
    void shouldShownSuccessMessageAfterCheckout() {

        FakePrintStream printStream = new FakePrintStream();
        Library library = new Library(mockLibrary, printStream, System.in);

        library.setBookId(0);
        library.checkoutBook();

        assertThat(printStream.printedString(), is("Thank you! Enjoy the book! \n"));
    }

    @Test
    void shouldShownFailMessageWhenCannotCheckout() {

        FakePrintStream printStream = new FakePrintStream();
        Library library = new Library(mockLibrary, printStream, System.in);

        library.setBookId(10);
        library.checkoutBook();

        assertThat(printStream.printedString(), is("Sorry, that book is not available\n"));
    }

    @Test
    public void shouldRemoveBookFromListWhenCheckoutIsSuccessful() {

        FakePrintStream printStream = new FakePrintStream();
        Library library = new Library(mockLibrary, printStream, System.in);

        library.setBookId(0);
        library.checkoutBook();
        library.listBooks();

        assertThat(printStream.printedString(), is("[2] Book B - Robert C Martin. (2011)\n"));
    }
}