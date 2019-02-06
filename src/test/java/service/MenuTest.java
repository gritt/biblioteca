package service;

import io.FakePrintStream;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void shouldShowMenu() {

        FakePrintStream printStream = new FakePrintStream();
        Menu menu = new Menu(printStream);

        menu.show();

        assertThat(printStream.printedString(), is("[1] List Books\n\nPlease chose an option [number]: "));
    }

    @Test
    void shouldReturnActionWhenGivingThenId() {
    }

    @Test
    void should() {
    }
}