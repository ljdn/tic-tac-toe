package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

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
        when(bufferedReader.readLine()).thenReturn("stop");

    }

    @Test
    public void shouldDisplayGameBoardWhenStarting() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        game.start();
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }

    @Test
    public void shouldAskFirstPlayerForMoveWhenStarting() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        game.start();
        verify(printStream).println("Player 1: Make a move");

    }

    @Test
    public void shouldRedrawBoardWithXInLocation1WhenPlayer1ChoosesLocation1() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        game.start();
        verify(printStream, atLeastOnce()).println("X|2|3\n-----\n4|5|6\n-----\n7|8|9");

    }

    @Test
    public void shouldRedrawBoardWithXInLocation2WhenPlayer1ChoosesLocation2() throws Exception {
        when(bufferedReader.readLine()).thenReturn("2", "1");
        game.start();
        verify(printStream, atLeastOnce()).println("1|X|3\n-----\n4|5|6\n-----\n7|8|9");

    }

    @Test
    public void shouldAskSecondPlayerForMoveWhenPlayerOneHasMoved() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        game.start();
        verify(printStream).println("Player 2: Make a move");

    }

    @Test
    public void shouldRedrawBoardWithOInLocation1WhenPlayer2ChoosesLocation1() throws Exception {
        when(bufferedReader.readLine()).thenReturn("2", "1");
        game.start();
        verify(printStream).println("O|X|3\n-----\n4|5|6\n-----\n7|8|9");
    }

    @Test
    public void shouldDisplayErrorMessageWhenPlayerSelectsLocationThatIsOccupied() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "1", "2");
        game.start();
        verify(printStream).println("Location already taken!");

    }

    @Test
    public void shouldAllowUserToKeepSelectingMovesUntilOneIsValid() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "1", "1", "2");
        game.start();
        verify(printStream).println("X|O|3\n-----\n4|5|6\n-----\n7|8|9");

    }
}
