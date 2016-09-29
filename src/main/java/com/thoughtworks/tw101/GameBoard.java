package com.thoughtworks.tw101;

import java.io.PrintStream;

/**
 * Created by lduan on 9/29/16.
 */
public class GameBoard {

    private PrintStream printStream;
    private String[][] cells;

    public GameBoard(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void initialize() {
        cells = new String[][] {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};
    }

    public void display() {
        String border = "\n-----\n";
        String row1 = cells[0][0] + "|" + cells[0][1] + "|" + cells[0][2];
        String row2 = cells[1][0] + "|" + cells[1][1] + "|" + cells[1][2];
        String row3 = cells[2][0] + "|" + cells[2][1] + "|" + cells[2][2];
        printStream.println(row1 + border + row2 + border + row3);
    }
}
