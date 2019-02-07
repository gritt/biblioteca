package io;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

class WriterTest {

    @Test
    public void shouldPrintAnyString() {

        FakePrintStream printStream = new FakePrintStream();

        Writer writer = new Writer(printStream);
        writer.print("Hello World");

        assertThat(printStream.printedString(), is("Hello World"));
    }
}