package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;

/**
 * Created by lduan on 10/2/16.
 */
public class Player {
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Board board;
    private String symbol;

    public Player(BufferedReader bufferedReader, PrintStream printStream, Board board, String symbol) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.board = board;
        this.symbol = symbol;
    }

    public void move() {
        printStream.println("Choose a number between 1 and 9 to move");
        int location = getInput();
        board.update(location, this.symbol);
        board.draw();
    }

    private int getInput() {
        int location = 0;
        try {
            location = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return location;
    }
}
