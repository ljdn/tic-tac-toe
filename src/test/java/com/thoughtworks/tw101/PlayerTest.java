package com.thoughtworks.tw101;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lduan on 10/2/16.
 */
public class PlayerTest {
    private Player player;
    private PrintStream printStream;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        player = new Player(printStream);
    }

    @Test
    public void shouldPromptUserForInputWhenMoving() throws Exception {
        player.move();
        verify(printStream).println("Choose a number between 1 and 9 to move");

    }
}