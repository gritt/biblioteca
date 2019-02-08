package service;

import entity.Book;
import entity.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

class LibraryServiceTest {

    private Map<Integer, Book> mockBooks = new HashMap<Integer, Book>();

    private LibraryService libraryService;

    @BeforeEach
    public void setMockBooks() {

        Book bookA = new Book()
                .setId(11)
                .setAvailable(true)
                .setName("Book A")
                .setAuthor("Erich Gama")
                .setYear(1994);

        Book bookB = new Book()
                .setId(22)
                .setAvailable(true)
                .setName("Book B")
                .setAuthor("Robert C Martin")
                .setYear(2008);

        Book bookC = new Book()
                .setId(33)
                .setAvailable(true)
                .setName("Book C")
                .setAuthor("Robert C Martin")
                .setYear(2011);

        Book bookD = new Book()
                .setId(44)
                .setAvailable(false)
                .setName("Book D")
                .setAuthor("Joel Grus")
                .setYear(2015);

        Book bookE = new Book()
                .setId(55)
                .setAvailable(false)
                .setName("Book E")
                .setAuthor("Maurice J. Thompson")
                .setYear(2018);

        /*
         * available books
         */
        mockBooks.put(bookA.getId(), bookA);
        mockBooks.put(bookB.getId(), bookB);
        mockBooks.put(bookC.getId(), bookC);

        /*
         * unavailable books
         */
        mockBooks.put(bookD.getId(), bookD);
        mockBooks.put(bookE.getId(), bookE);
    }

    @BeforeEach
    public void setLibraryService() {

        libraryService = new LibraryService();
    }

    @Test
    public void shouldReturnEmptyWhenLibraryIsEmpty() {

        Library empty = new Library(new HashMap<Integer, Book>());

        libraryService.setLibrary(empty);

        assertThat(libraryService.listBooks(), is(""));
    }

    @Test
    public void shouldReturnListOfBooksWhenLibraryHasBooks() {

        Library libraryWithBooks = new Library(mockBooks);

        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.listBooks(), is(
                "[33]. Book C - Robert C Martin. 2011\n" +
                        "[22]. Book B - Robert C Martin. 2008\n" +
                        "[11]. Book A - Erich Gama. 1994\n"
        ));
    }

    @Test
    public void shouldReturnEmptyWhenNoBooksAreReserved() {

        Library empty = new Library(new HashMap<Integer, Book>());

        libraryService.setLibrary(empty);

        assertThat(libraryService.listReservations(), is(""));
    }

    @Test
    public void shouldReturnListOfReservedBooksWhenBooksAreReserved() {

        Library library = new Library(mockBooks);

        libraryService.setLibrary(library);

        assertThat(libraryService.listReservations(), is(
                "[55]. Book E - Maurice J. Thompson. 2018\n" +
                        "[44]. Book D - Joel Grus. 2015\n"
        ));
    }

    @Test
    public void shouldReserveBookWhenValidIdIsGiven() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.checkoutBook(11), is(true));
    }

    @Test
    public void shouldNotReserveBookWhenInvalidIdIsGiven() {

        Library libraryWithBooks = new Library(mockBooks);

        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.checkoutBook(100), is(false));
    }

    @Test
    public void shouldNotReserveBookWhenLibraryIsEmpty() {

        Library empty = new Library(new HashMap<Integer, Book>());

        libraryService.setLibrary(empty);

        assertThat(libraryService.checkoutBook(0), is(false));
    }

    @Test
    public void shouldRemoveBookFromListOnCheckout() {

        Library library = new Library(mockBooks);
        libraryService.setLibrary(library);

        libraryService.checkoutBook(11);

        assertThat(libraryService.listBooks(), is(
                "[33]. Book C - Robert C Martin. 2011\n" +
                        "[22]. Book B - Robert C Martin. 2008\n"
        ));

        libraryService.checkoutBook(22);

        assertThat(libraryService.listBooks(), is(
                "[33]. Book C - Robert C Martin. 2011\n"
        ));
    }

    @Test
    public void shouldReserveMultipleBooksWhenAvailable() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.checkoutBook(22), is(true));
        assertThat(libraryService.checkoutBook(11), is(true));
        assertThat(libraryService.checkoutBook(33), is(true));
    }

    @Test
    public void shouldNotReserveMultipleBooksWhenThereAreNoBooksLeft() {
        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.checkoutBook(11), is(true));
        assertThat(libraryService.checkoutBook(22), is(true));
        assertThat(libraryService.checkoutBook(33), is(true));

        assertThat(libraryService.checkoutBook(11), is(false));
    }

    @Test
    public void shouldReturnBookWhenIsReserved() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.returnBook(44), is(true));
    }

    @Test
    public void shouldNotReturnBookWhenIsNotReserved() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.returnBook(33), is(false));
    }

    @Test
    public void shouldNotReturnWhenIdIsInvalid() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.returnBook(200), is(false));
    }
}