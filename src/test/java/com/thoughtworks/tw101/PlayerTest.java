package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lduan on 10/2/16.
 */
public class PlayerTest {
    private Player player1;
    private PrintStream printStream;
    private Board board;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        player1 = new Player(bufferedReader, printStream, board, "X");
    }

    @Test
    public void shouldPromptUserForInputWhenMoving() throws Exception {
        when(bufferedReader.readLine()).thenReturn("0");
        player1.move();
        verify(printStream).println("Choose a number between 1 and 9 to move");

    }

    @Test
    public void shouldRedrawBoardWhenMoving() throws Exception {
        when(bufferedReader.readLine()).thenReturn("0");
        player1.move();
        verify(board).draw();

    }

    @Test
    public void shouldUpdateBoardWhenMoving() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        player1.move();
        verify(board).update(1, "X");

    }

    @Test
    public void shouldDisplayErrorMessageIfLocationIsTakenWhenMoving() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.cellIsOccupied(anyInt())).thenReturn(true);
        player1.move();
        verify(printStream).println(contains("taken"));

    }
}