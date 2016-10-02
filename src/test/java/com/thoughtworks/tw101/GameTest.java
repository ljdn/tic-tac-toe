package com.thoughtworks.tw101;

import com.sun.media.jfxmedia.events.PlayerStateEvent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.verify;

/**
 * Created by lduan on 10/2/16.
 */
public class GameTest {
    private Game game;
    private Board board;
    private Player player1;
    private Player player2;


    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2);
    }

    @Test
    public void shouldDrawGameBoardWhenStarting() throws Exception {
        game.start();
        verify(board).draw();

    }

    @Test
    public void shouldPromptPlayer1ForMoveWhenStarting() throws Exception {
        game.start();
        verify(player1).move();

    }
}