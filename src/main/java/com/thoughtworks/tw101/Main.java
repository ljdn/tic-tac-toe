package com.thoughtworks.tw101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by lduan on 9/29/16.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(new PrintStream(System.out), new BufferedReader(new InputStreamReader(System.in)));
        game.start();

    }

}
