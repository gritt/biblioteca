package service;

import entity.Book;
import entity.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

class LibraryServiceTest {

    private List<Book> mockBooks = new ArrayList<>();

    private LibraryService libraryService;

    @BeforeEach
    public void setMockBooks() {

        Book designPatterns = new Book()
                .setName("Book A")
                .setAuthor("Erich Gama")
                .setYear(1994);

        Book cleanCode = new Book()
                .setName("Book B")
                .setAuthor("Robert C Martin")
                .setYear(2008);

        Book theCleanCoder = new Book()
                .setName("Book C")
                .setAuthor("Robert C Martin")
                .setYear(2011);


        mockBooks.add(designPatterns);
        mockBooks.add(cleanCode);
        mockBooks.add(theCleanCoder);
    }

    @BeforeEach
    public void setLibraryService() {

        libraryService = new LibraryService();
    }

    @Test
    public void shouldReturnEmptyWhenLibraryIsEmpty() {

        Library emptyLibrary = new Library(new ArrayList<>());

        libraryService.setLibrary(emptyLibrary);

        assertThat(libraryService.listBooks(), is(""));
    }

    @Test
    public void shouldReturnListOfBooksWhenLibraryHasBooks() {

        Library libraryWithBooks = new Library(mockBooks);

        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.listBooks(), is(
                "[0]. Book A - Erich Gama. 1994\n" +
                        "[1]. Book B - Robert C Martin. 2008\n" +
                        "[2]. Book C - Robert C Martin. 2011\n"
        ));
    }

    @Test
    public void shouldReturnEmptyWhenNoBooksAreReserved() {

        Library emptyLibrary = new Library(new ArrayList<>());

        libraryService.setLibrary(emptyLibrary);

        assertThat(libraryService.listReservations(), is(""));
    }

    @Test
    public void shouldReturnListOfReservedBooksWhenBooksAreReserved() {

        Library libraryWithReservations = new Library(new ArrayList<>());
        libraryWithReservations.addReservation(mockBooks.get(0));
        libraryWithReservations.addReservation(mockBooks.get(1));

        libraryService.setLibrary(libraryWithReservations);

        assertThat(libraryService.listReservations(), is(
                "[0]. Book A - Erich Gama. 1994\n" +
                        "[1]. Book B - Robert C Martin. 2008\n"
        ));
    }

    @Test
    public void shouldReserveBookWhenValidIdIsGiven() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.checkoutBook(0), is(true));
    }

    @Test
    public void shouldNotReserveBookWhenInvalidIdIsGiven() {

        Library libraryWithBooks = new Library(mockBooks);

        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.checkoutBook(4), is(false));
    }

    @Test
    public void shouldNotReserveBookWhenLibraryIsEmpty() {

        Library emptyLibrary = new Library(new ArrayList<>());

        libraryService.setLibrary(emptyLibrary);

        assertThat(libraryService.checkoutBook(0), is(false));
    }

    @Test
    public void shouldRemoveBookFromListOnCheckout() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        libraryService.checkoutBook(0);

        assertThat(libraryService.listBooks(), is(
                "[0]. Book B - Robert C Martin. 2008\n" +
                        "[1]. Book C - Robert C Martin. 2011\n"
        ));

        libraryService.checkoutBook(1);

        assertThat(libraryService.listBooks(), is(
                "[0]. Book B - Robert C Martin. 2008\n"
        ));
    }

    @Test
    public void shouldReserveMultipleBooksWhenAvailable() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.checkoutBook(0), is(true));
        assertThat(libraryService.checkoutBook(0), is(true));
        assertThat(libraryService.checkoutBook(0), is(true));
    }

    @Test
    public void shouldNotReserveMultipleBooksWhenThereAreNoBooksLeft() {
        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.checkoutBook(0), is(true));
        assertThat(libraryService.checkoutBook(0), is(true));
        assertThat(libraryService.checkoutBook(0), is(true));

        assertThat(libraryService.checkoutBook(0), is(false));
    }

    @Test
    public void shouldReturnBookWhenIsReserved() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        libraryService.checkoutBook(0);

        assertThat(libraryService.returnBook(0), is(true));
    }

    @Test
    public void shouldNotReturnBookWhenIsNotReserved() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        assertThat(libraryService.returnBook(0), is(false));
    }

    @Test
    public void shouldNotReturnWhenIdIsInvalid() {

        Library libraryWithBooks = new Library(mockBooks);
        libraryService.setLibrary(libraryWithBooks);

        libraryService.checkoutBook(0);

        assertThat(libraryService.returnBook(1), is(false));
    }
}