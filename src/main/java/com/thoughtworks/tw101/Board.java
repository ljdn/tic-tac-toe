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
        printStream.println(String.format("%s|%s|%s\n-----\n%s|%s|%s\n-----\n%s|%s|%s", cells));

    }

    public void update(int location, String symbol) {
        cells[location-1] = symbol;
    }

    public String getCell(int location) {
        return cells[location-1];
    }
}
