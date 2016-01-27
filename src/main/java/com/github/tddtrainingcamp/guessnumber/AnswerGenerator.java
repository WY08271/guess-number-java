package com.github.tddtrainingcamp.guessnumber;


public class AnswerGenerator {
    private static int counter = 0;

    public static String genrate() {
        counter++;
        if(counter % 2 == 0) return "1234";

        return "2345";
    }
}
