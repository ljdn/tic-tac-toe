package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lduan on 10/2/16.
 */
public class GameTest {
    private Game game;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        game = new Game(board);
    }

    @Test
    public void shouldDrawGameBoardWhenStarting() throws Exception {
        game.start();
        verify(board).draw();

    }
}