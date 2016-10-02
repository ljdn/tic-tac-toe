package com.thoughtworks.tw101;

import com.thoughtworks.tw101.Game;

/**
 * Created by lduan on 10/2/16.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Board());
        game.start();
    }
}
