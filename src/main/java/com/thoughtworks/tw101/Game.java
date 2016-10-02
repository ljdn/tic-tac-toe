package com.thoughtworks.tw101;

/**
 * Created by lduan on 10/2/16.
 */
public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void start() {
        board.draw();
    }
}
