package com.datumsapiens.mathstabledodging.struct;

import lombok.Value;
import lombok.experimental.NonFinal;

@Value
public class AnalysedData {
    private int numTables;
    private int[] questionsAskedForTable;
    private int[] questionsAnsweredCorrectlyForTable;
    private double[] tableTimeTakenToAnswerForTable;
    @NonFinal
    private int totalQuestionsAsked;
    @NonFinal
    private int totalQuestionsCorrect;

    public void IncrementTableQuestionsAskedBy(int index, int value) {
        questionsAskedForTable[index] += value;
        totalQuestionsAsked++;
    }

    public void IncrementTableQuestionsAnsweredBy(int index, int value) {
        questionsAnsweredCorrectlyForTable[index] += value;
        if (value == 1)
            totalQuestionsCorrect++;

    }

    public void IncrementTableTimeTakenBy(int index, double value) {
        tableTimeTakenToAnswerForTable[index] += value;
    }

    public int getQuestionsAskedForTable(int index) {
        return questionsAskedForTable[index];
    }

    public int getQuestionsAnsweredCorrectlyForTable(int index) {
        return questionsAnsweredCorrectlyForTable[index];
    }

    public double getTableTimeTakenToAnswerForTable(int index) {
        return tableTimeTakenToAnswerForTable[index];
    }

}