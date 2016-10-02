package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by lduan on 10/2/16.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player player1 = new Player(bufferedReader, printStream, board, "X");
        Player player2 = new Player(bufferedReader, printStream, board, "O");
        Game game = new Game(board, player1, player2);
        game.start();
    }
}
