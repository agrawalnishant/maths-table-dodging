package com.datumsapiens.mathstabledodging.struct;

import lombok.Value;

import java.time.Instant;
import java.util.HashMap;

@Value
public class StartParams {
    public static HashMap<QUESTION_KEYS, String> QUESTIONS = new HashMap<>();

    static {
        QUESTIONS.put(QUESTION_KEYS.TABLE_TO, "Largest table to test?:");
        QUESTIONS.put(QUESTION_KEYS.PLAYER_NAME, "Name of player?:");
        QUESTIONS.put(QUESTION_KEYS.NUM_QUESTIONS, "Number of questions to ask?:");
    }

    private Instant time;
    private Integer tablesTo;
    private String playerName;
    private Integer numQuestions;
    public StartParams(
            final Integer tablesTo,
            final String playerName,
            final Integer numQuestions) {
        this.time = Instant.now();
        this.tablesTo = tablesTo;
        this.playerName = playerName;
        this.numQuestions = numQuestions;
    }

    @Override
    public String toString() {
        return "Will now ask  " + numQuestions + " dodging questions for '" + playerName + "' upto table of " + tablesTo + " .";
    }

    public enum QUESTION_KEYS {TABLE_TO, PLAYER_NAME, NUM_QUESTIONS}
}
