package com.thoughtworks.tw101;

import java.io.PrintStream;

/**
 * Created by lduan on 10/2/16.
 */
public class Board {
    private PrintStream printStream;
    private String[] cells;

    public Board(PrintStream printStream, String[] cells) {
        this.cells = cells;
        this.printStream = printStream;
    }

    public void draw() {
        printStream.println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");

    }

    public void update(int location, String symbol) {
        cells[location-1] = symbol;
    }

    public String getCell(int location) {
        return cells[location-1];
    }
}
