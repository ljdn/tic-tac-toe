package com.thoughtworks.tw101;

import java.io.PrintStream;

/**
 * Created by lduan on 9/29/16.
 */
public class Game {
    private PrintStream printStream;

    public Game(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void start() {
        printStream.println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
        printStream.println("Player 1: Make a move");
    }
}
