package com.thoughtworks.tw101;

import java.io.PrintStream;

/**
 * Created by lduan on 10/2/16.
 */
public class Player {
    private PrintStream printStream;

    public Player(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void move() {
        printStream.println("Choose a number between 1 and 9 to move");

    }
}
