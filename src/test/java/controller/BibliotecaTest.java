package controller;

import entity.MockEmptyLibrary;
import entity.MockLibrary;
import io.FakePrintStream;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class BibliotecaTest {

    @Test
    public void shouldListBooks() {

        FakePrintStream printStream = new FakePrintStream();

        Biblioteca biblioteca = new Biblioteca(new MockLibrary(), printStream);
        biblioteca.listBooks();

        assertThat(printStream.printedString(), is(
                "[1] Design Patterns, Elements of Reusable Object-Oriented-Software - Erich Gama. (1994)\n" +
                        "[2] Clean Code - Robert C Martin. (2008)\n" +
                        "[3] The Clean Coder - Robert C Martin. (2011)\n"
        ));
    }

    @Test
    public void shouldListEmptyWhenThereAreNoBooks()
    {
        FakePrintStream printStream = new FakePrintStream();

        Biblioteca biblioteca = new Biblioteca(new MockEmptyLibrary(), printStream);
        biblioteca.listBooks();

        assertThat(printStream.printedString(), is(""));
    }
}