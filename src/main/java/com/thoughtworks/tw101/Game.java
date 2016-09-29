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
    private String gameBoard = "1|2|3\n-----\n4|5|6\n-----\n7|8|9";

    public Game(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void start() {
        printStream.println(gameBoard);
        printStream.println("Player 1: Make a move");
        playerMove();
        printStream.println(gameBoard);
        printStream.println("Player 2: Make a move");
    }

    private void playerMove() {
        try {
            String move = bufferedReader.readLine();
            switch (move) {
                case "1":
                    gameBoard = "X|2|3\n-----\n4|5|6\n-----\n7|8|9";
                    break;
                case "2":
                    gameBoard = "1|X|3\n-----\n4|5|6\n-----\n7|8|9";
                    break;
                case "3":
                    gameBoard = "1|2|X\n-----\n4|5|6\n-----\n7|8|9";
                    break;
                case "4":
                    gameBoard = "1|2|3\n-----\nX|5|6\n-----\n7|8|9";
                    break;
                case "5":
                    gameBoard = "1|2|3\n-----\n4|X|6\n-----\n7|8|9";
                    break;
                case "6":
                    gameBoard = "1|2|3\n-----\n4|5|X\n-----\n7|8|9";
                    break;
                case "7":
                    gameBoard = "1|2|3\n-----\n4|5|6\n-----\nX|8|9";
                    break;
                case "8":
                    gameBoard = "1|2|3\n-----\n4|5|6\n-----\n7|X|9";
                    break;
                case "9":
                    gameBoard = "1|2|3\n-----\n4|5|6\n-----\n7|8|X";
                    break;

            }

        } catch (IOException e) { e.printStackTrace(); }
    }
}
