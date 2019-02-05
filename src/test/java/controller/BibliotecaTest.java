package controller;

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
                "[1] Design Patterns, Elements of Reusable Object-Oriented-Software by Erich Gama\n" +
                        "[2] Clean Code by Robert C Martin\n" +
                        "[3] The Clean Coder by Robert C Martin\n"
        ));
    }
}