package io;

import java.io.PrintStream;

public class Writer {

    private PrintStream printStream;

    public Writer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String message) {
        this.printStream.println(message);
    }
}
