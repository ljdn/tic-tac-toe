package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lduan on 9/29/16.
 */
public class GameTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Game game;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        game = new Game(printStream, bufferedReader);

    }

    @Test
    public void shouldDisplayGameBoardWhenStarting() throws Exception {
        game.start();
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }

    @Test
    public void shouldAskFirstPlayerForMoveWhenStarting() throws Exception {
        game.start();
        verify(printStream).println("Player 1: Make a move");

    }

    @Test
    public void shouldRedrawBoardWithXInLocation1WhenPlayerChoosesLocation1() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        game.start();
        verify(printStream).println("X|2|3\n-----\n4|5|6\n-----\n7|8|9");

    }
}
