package com.datumsapiens.mathstabledodging.struct;

import lombok.Value;

@Value
public class Answer {
    public static final String NO_RESPONSE = "/";

    private Result result;
    private Integer actualAnswer;
    private Integer expectedAnswer;
    private Long timeTaken;

    public Answer(final Integer actualAnswer,
                  final Integer expectedAnswer, final Long timeTaken) {
        this.actualAnswer = actualAnswer;
        this.expectedAnswer = expectedAnswer;
        this.result = actualAnswer == expectedAnswer ? Result.CORRECT : Result.WRONG;
        this.timeTaken = timeTaken;
    }

    public Answer(
            final Integer expectedAnswer, final Long timeTaken) {
        this.actualAnswer = null;
        this.expectedAnswer = expectedAnswer;
        this.result = Result.NONE;
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return " | " + (actualAnswer != null ? actualAnswer : "??") + "     Expected: " + expectedAnswer + "  , Time Taken:  " + timeTaken + " seconds.";
    }
}
