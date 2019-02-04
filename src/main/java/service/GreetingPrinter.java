package service;

import io.Presenter;

import java.io.PrintStream;

public class GreetingPrinter {

    private Presenter presenter;

    public GreetingPrinter(PrintStream printStream) {
        Presenter presenter = new Presenter(printStream);
    }

    public void printWelcome() {
        presenter.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }
}
