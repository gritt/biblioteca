package service;

import io.Writer;

import java.io.PrintStream;

public class Welcome {

    private Writer writer;

    public Welcome(PrintStream printStream) {
        this.writer = new Writer(printStream);
    }

    public void show() {
        this.writer.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }
}
