package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lduan on 9/29/16.
 */
public class GameTest {
    private PrintStream printStream;
    private Game game;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        game = new Game(printStream);

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
}
