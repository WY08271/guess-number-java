package com.github.tddtrainingcamp.guessnumber;

import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Thoughtworks on 1/26/16.
 */
public class GameTest {

    @Test
    public void welcome_when_start_game() throws Exception {

        BufferedReader reader = mock(BufferedReader.class);
        PrintStream out = mock(PrintStream.class);
        Game game = new Game(reader, out);
        when(reader.readLine()).thenReturn("");

        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
    }

    @Test
    public void congratulation_when_first_try_match() throws Exception {
        BufferedReader reader = mock(BufferedReader.class);
        PrintStream out = mock(PrintStream.class);
        Game game = new Game(reader, out);
        when(reader.readLine()).thenReturn("1234");

        game.start();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Congratulation");
    }

    @Test
    public void generate_answer_is_random() throws Exception {
        String answer1 = AnswerGenerator.genrate();
        String answer2 = AnswerGenerator.genrate();
        assertThat(answer1.equals(answer2), is(false));
    }
}