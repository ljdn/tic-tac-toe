package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lduan on 9/29/16.
 */
public class GameBoardTest {

    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);

    }

    @Test
    public void shouldCreateEmptyBoardWhenInitializing() throws Exception {
        GameBoard gameBoard = new GameBoard(printStream);
        gameBoard.initialize();
        gameBoard.display();
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");

    }
}