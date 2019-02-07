package service;

import io.FakePrintStream;
import io.Writer;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class WelcomeTest {

    @Test
    void shouldPrintWelcome() {

        FakePrintStream printStream = new FakePrintStream();

        Writer writer = new Writer(printStream);
        writer.print("Welcome to Library. Your one-stop-shop for great book titles in Bangalore!\n");

        assertThat(printStream.printedString(), is("Welcome to Library. Your one-stop-shop for great book titles in Bangalore!\n"));
    }
}