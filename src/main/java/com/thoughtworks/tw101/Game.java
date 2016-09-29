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
        playerMove(1);
        printStream.println(gameBoard);
        printStream.println("Player 2: Make a move");
        playerMove(2);
        printStream.println(gameBoard);
    }

    private void playerMove(int player) {
        String token;
        if (player == 1) {
            token = "X";
        }
        else {
            token = "O";
        }
        try {
            String move = bufferedReader.readLine();
            gameBoard = gameBoard.replace(move, token);
        } catch (IOException e) { e.printStackTrace(); }
    }
}
