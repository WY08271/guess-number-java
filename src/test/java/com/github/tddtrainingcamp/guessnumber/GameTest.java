package com.github.tddtrainingcamp.guessnumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private BufferedReader reader;

    @Mock
    private PrintStream out;

    @Mock
    private Guess guess;

    @Mock
    private AnswerGenerator answer;

    private Game game() {
        return new Game(reader, out);
    }

    private InOrder verifyInOrder() {
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
        return inOrder;
    }

    @Test
    public void welcome_when_start() throws IOException {

        when(reader.readLine()).thenReturn("1234");

        game().start();

        verifyInOrder();
    }

    @Test
    public void congratulations_when_input_first() throws IOException {

        when(reader.readLine()).thenReturn("1234");

        game().start();

        InOrder inOrder = verifyInOrder();
        inOrder.verify(out).println("Congratulations!");
    }

    @Test
    public void congratulations_when_input_round() throws IOException {

        when(answer.generate()).thenReturn("1234");
        when(reader.readLine()).thenReturn("5678").thenReturn("1234");

        when(guess.compare("1234","5678")).thenReturn("0A0B");
        when(guess.compare("1234","1234")).thenReturn("4A0B");

        game().start();

        InOrder inOrder = verifyInOrder();
        inOrder.verify(out).println("0A0B");
        inOrder.verify(out).println("Please input your number(5):");
        inOrder.verify(out).println("Congratulations!");
    }

}