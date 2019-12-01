package com.datumsapiens.mathstabledodging.struct;

import lombok.Value;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

@Value
public class Question {
    private Integer table;
    private Integer multiplier;

    public Answer ask(final Integer questionNumber) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n Q:" + questionNumber + this);
        Instant start = Instant.now();
        String input = scan.next();
        Long timeTaken = Duration.between(start, Instant.now()).toSeconds();

        return Answer.NO_RESPONSE.equals(input) ? (new Answer(table * multiplier, timeTaken)) :
                (new Answer(Integer.valueOf(input), table * multiplier,
                        timeTaken));
    }

    @Override
    public String toString() {
        return "\t" + table + " X " + multiplier + " = :";
    }

}
