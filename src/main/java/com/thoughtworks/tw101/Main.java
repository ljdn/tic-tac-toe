package com.thoughtworks.tw101;

import java.io.PrintStream;

/**
 * Created by lduan on 10/2/16.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Game game = new Game(new Board(printStream), new Player(printStream), new Player(printStream));
        game.start();
    }
}
