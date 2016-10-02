package com.thoughtworks.tw101;

import java.io.PrintStream;

/**
 * Created by lduan on 10/2/16.
 */
public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void draw() {
        printStream.println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");

    }

    public void update(int location, String symbol) {

    }
}
