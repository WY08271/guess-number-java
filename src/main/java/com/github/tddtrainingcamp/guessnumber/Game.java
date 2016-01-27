package com.github.tddtrainingcamp.guessnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Thoughtworks on 1/26/16.
 */
public class Game {
    private BufferedReader reader;
    private PrintStream out;
    private Guess guess;
    private AnswerGenerator answer;
    private int remain = 6;

    public Game(BufferedReader reader, PrintStream out,Guess guess, AnswerGenerator answer) {
        this.reader = reader;
        this.out = out;
        this.guess = guess;
        this.answer = answer.generate();
    }

    public void start() throws IOException {
        out.println("Welcome!");
        out.println();
        out.println("Please input your number(6):");
        run();
    }

    private void run() throws IOException {
        String input = reader.readLine();

        if (input.equals("1234")) {
            out.println("Congratulations!");
        }
    }
}
