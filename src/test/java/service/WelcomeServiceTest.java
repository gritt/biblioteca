package service;

import io.FakePrintStream;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class WelcomeServiceTest {

    @Test
    void shouldPrintWelcome() {

        FakePrintStream printStream = new FakePrintStream();

        WelcomeService welcomeService = new WelcomeService(printStream);
        welcomeService.show();

        assertThat(printStream.printedString(), is("WelcomeService to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n"));
    }
}