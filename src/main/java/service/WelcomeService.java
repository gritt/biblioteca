package service;

import io.Writer;

import java.io.PrintStream;

public class WelcomeService {

    private Writer writer;

    public WelcomeService(PrintStream printStream) {
        this.writer = new Writer(printStream);
    }

    public void show() {
        this.writer.print("WelcomeService to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }
}
