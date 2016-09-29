package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lduan on 9/29/16.
 */
public class Game {
    private GameBoard board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private String gameBoard = "1|2|3\n-----\n4|5|6\n-----\n7|8|9";
    private int moves;

    public Game(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = new GameBoard(printStream);
        this.moves = 0;
    }

    public void start() {
        printStream.println(gameBoard);
        board.initialize();
        board.display();

        while (this.moves < 9) {

            playerMove(1);
            if (hasWon("X")) {
                printStream.println("Player 1 Wins!");
                return;
            }

            if (this.moves == 9) {
                printStream.println("Game is a draw");
                return;
            }

            playerMove(2);
            if (hasWon("O")) {
                printStream.println("Player 2 Wins!");
                return;
            }

        }

    }

    private boolean hasWon(String token) {
        return gameBoard.contains(token + "|" + token + "|" +token);
    }

    private void playerMove(int player) {
        printStream.println("Player " + player + ": Make a move");

        String token;
        if (player == 1) {
            token = "X";
        }
        else {
            token = "O";
        }

        try {
            String move = bufferedReader.readLine();
            while (!(gameBoard.contains(move))) {
                printStream.println("Location already taken!");
                printStream.println("Try again");
                move = bufferedReader.readLine();
            }
            gameBoard = gameBoard.replace(move, token);

        } catch (IOException e) { e.printStackTrace(); }

        printStream.println(gameBoard);
        this.moves++;
    }
}
