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
    private GameBoard gameBoard;
    private Game game;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        gameBoard = mock(GameBoard.class);
        when(bufferedReader.readLine()).thenReturn("1","2","3","4","5","6","7","8","9");
        game = new Game(printStream, bufferedReader);

    }

    @Test
    public void shouldDisplayGameBoardWhenStarting() throws Exception {
        game.start();
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }

    @Test
    public void shouldInitializeBoardWhenStarting() throws Exception {
        game.start();
        verify(gameBoard).initialize();
    }

    @Test
    public void shouldDisplayInitialBoardWhenStarting() throws Exception {
        game.start();
        verify(gameBoard).display();

    }

    @Test
    public void shouldAskFirstPlayerForMoveWhenStarting() throws Exception {
        game.start();
        verify(printStream, atLeastOnce()).println("Player 1: Make a move");

    }

    @Test
    public void shouldRedrawBoardWithXInLocation1WhenPlayer1ChoosesLocation1() throws Exception {
        game.start();
        verify(printStream, atLeastOnce()).println("X|2|3\n-----\n4|5|6\n-----\n7|8|9");

    }

    @Test
    public void shouldRedrawBoardWithXInLocation2WhenPlayer1ChoosesLocation2() throws Exception {
        when(bufferedReader.readLine()).thenReturn("2","1","3","4","5","6","7","8","9");
        game.start();
        verify(printStream, atLeastOnce()).println("1|X|3\n-----\n4|5|6\n-----\n7|8|9");

    }

    @Test
    public void shouldAskSecondPlayerForMoveWhenPlayerOneHasMoved() throws Exception {
        game.start();
        verify(printStream, atLeastOnce()).println("Player 2: Make a move");

    }

    @Test
    public void shouldRedrawBoardWithOInLocation1WhenPlayer2ChoosesLocation1() throws Exception {
        when(bufferedReader.readLine()).thenReturn("2","1","3","4","5","6","7","8","9");
        game.start();
        verify(printStream).println("O|X|3\n-----\n4|5|6\n-----\n7|8|9");
    }

    @Test
    public void shouldDisplayErrorMessageWhenPlayerSelectsLocationThatIsOccupied() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1","1,","2","3","4","5","6","7","8","9");
        game.start();
        verify(printStream).println("Location already taken!");

    }

    @Test
    public void shouldAllowUserToKeepSelectingMovesUntilOneIsValid() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1","1", "1", "2","3","4","5","6","7","8","9");
        game.start();
        verify(printStream).println("X|O|3\n-----\n4|5|6\n-----\n7|8|9");

    }

    @Test
    public void shouldAlternateTurnsWhenBoardIsNotFull() throws Exception {
        game.start();
        verify(printStream).println("X|O|X\n-----\nO|X|O\n-----\nX|O|X");

    }

    @Test
    public void shouldDisplayGameIsADrawMessageWhenBoardIsFull() throws Exception {
        game.start();
        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldEndGameWhenPlayer1HasWonByFillingRow() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "4", "2", "5", "3", "6", "7", "8", "9");
        game.start();
        verify(printStream).println("Player 1 Wins!");

    }

    @Test
    public void shouldEndGameWhenPlayer2HasWonByFillingRow() throws Exception {
        when(bufferedReader.readLine()).thenReturn("4","1","7","2","5","3","6","8","9");
        game.start();
        verify(printStream).println("Player 2 Wins!");

    }

    @Test
    //should fail
    public void shouldEndGameWhenPlayerWinsByFillingColumn() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1","2","4","3","7","5","6","8","9");
        game.start();
        verify(printStream).println("Player 1 Wins!");
    }
}
