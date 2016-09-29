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
        playerMove();
    }

    private void playerMove() {
        try {
            String move = bufferedReader.readLine();
            switch (move) {
                case "1":
                    printStream.println("X|2|3\n-----\n4|5|6\n-----\n7|8|9");
                    break;
                case "2":
                    printStream.println("1|X|3\n-----\n4|5|6\n-----\n7|8|9");
                    break;
                case "3":
                    printStream.println("1|2|X\n-----\n4|5|6\n-----\n7|8|9");
                    break;
                case "4":
                    printStream.println("1|2|3\n-----\nX|5|6\n-----\n7|8|9");
                    break;
                case "5":
                    printStream.println("1|2|3\n-----\n4|X|6\n-----\n7|8|9");
                    break;
                case "6":
                    printStream.println("1|2|3\n-----\n4|5|X\n-----\n7|8|9");
                    break;
                case "7":
                    printStream.println("1|2|3\n-----\n4|5|6\n-----\nX|8|9");
                    break;
                case "8":
                    printStream.println("1|2|3\n-----\n4|5|6\n-----\n7|X|9");
                    break;
                case "9":
                    printStream.println("1|2|3\n-----\n4|5|6\n-----\n7|8|X");
                    break;

            }

        } catch (IOException e) { e.printStackTrace(); }
    }
}
