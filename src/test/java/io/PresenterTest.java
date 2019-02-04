package io;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

class PresenterTest {

    @Test
    void print() {
    }

    @Test
    public void shouldPrintGreetings() {

        FakePrintStream printStream = new FakePrintStream();

        Presenter presenter = new Presenter(printStream);
        presenter.print("Greetings");

        assertThat(printStream.printedString(), is("Greetings"));
    }
}