package io;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

class PresenterTest {

    @Test
    void print() {
    }

    @Test
    public void shouldPrintAnyString() {

        FakePrintStream printStream = new FakePrintStream();

        Presenter presenter = new Presenter(printStream);
        presenter.print("Hello World");

        assertThat(printStream.printedString(), is("Hello World"));
    }
}