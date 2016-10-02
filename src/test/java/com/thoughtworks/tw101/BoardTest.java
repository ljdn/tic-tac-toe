package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lduan on 10/2/16.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private String[] cells = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream, cells);
    }

    @Test
    public void shouldPrintGridWhenDrawing() throws Exception {
        board.draw();
        verify(printStream).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");

    }

    @Test
    public void shouldUpdateCellsWhenUpdating() throws Exception {
        board.update(1, "X");
        assertEquals(board.getCell(1), "X");

    }
}