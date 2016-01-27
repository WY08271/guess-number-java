package com.github.tddtrainingcamp.guessnumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Thoughtworks on 1/26/16.
 */
public class Game {
    private BufferedReader reader;
    private PrintStream out;

    public Game(BufferedReader reader,PrintStream out){
        this.reader = reader;
        this.out = out;
    }

    public void start() throws IOException {
        out.println("Welcome!");
        out.println("Please input your number(6):");

        String input = reader.readLine();

        if(input.equals(AnswerGenerator.genrate())) {
            out.println("Congratulation");
        }
    }
}
