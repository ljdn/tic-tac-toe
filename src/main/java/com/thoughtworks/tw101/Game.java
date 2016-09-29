package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lduan on 9/29/16.
 */
public class Game {
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Game(PrintStream printStream, BufferedReader bufferedReader) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void start() {
        printStream.println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
        printStream.println("Player 1: Make a move");
        try {
            String move = bufferedReader.readLine();
            if (move.equals("1")) {
                printStream.println("X|2|3\n-----\n4|5|6\n-----\n7|8|9");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
