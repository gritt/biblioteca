package service;

import io.FakePrintStream;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class MenuTest {

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Test
    void shouldShowMenu() {

        FakePrintStream printStream = new FakePrintStream();
        Menu menu = new Menu(printStream);

        menu.show();

        assertThat(printStream.printedString(), is(
                "________________________________________" +
                        "\n[0] List Books" +
                        "\n[1] Checkou t Book" +
                        "\n[2] Close" +
                        "\n\nPlease select a valid menu option [number]: "
        ));
    }

    @Test
    void shouldReturnActionWhenGivingThenId() throws IndexOutOfBoundsException {

        FakePrintStream printStream = new FakePrintStream();
        Menu menu = new Menu(printStream);

        String method = menu.getAction(0);
        assertThat(method, is("listBooks"));
    }

    @Test
    void shouldThrowExceptionWhenInvalidOptionGiven() throws IndexOutOfBoundsException {

        FakePrintStream printStream = new FakePrintStream();
        Menu menu = new Menu(printStream);

        try {
            menu.getAction(4);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is("Invalid option given\n"));
        }
    }
}