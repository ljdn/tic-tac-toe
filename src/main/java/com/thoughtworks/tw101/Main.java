package com.thoughtworks.tw101;

/**
 * Created by lduan on 10/2/16.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Board(System.out), new Player(), new Player());
        game.start();
    }
}
