package service;

import io.FakePrintStream;
import io.Presenter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class GreetingPrinterTest {

    @Test
    void shouldPrintWelcome() {

        FakePrintStream printStream = new FakePrintStream();

        Presenter presenter = new Presenter(printStream);
        presenter.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");

        assertThat(printStream.printedString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n"));
    }
}