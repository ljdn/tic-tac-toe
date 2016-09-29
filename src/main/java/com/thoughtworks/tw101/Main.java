package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by lduan on 9/29/16.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Game game = new Game(printStream, new BufferedReader(new InputStreamReader(System.in)));
        game.start();

    }

}
