package io;

import java.io.InputStream;
import java.util.Scanner;

public class Reader {

    private InputStream inputStream;

    public Reader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int readNumber() {
        try {

            Scanner reader = new Scanner(inputStream);
            return reader.nextInt();

        } catch (Exception e) {
            /*
             * in case of invalid input (empty), return -1 (try again)
             */
            return -1;
        }
    }
}
