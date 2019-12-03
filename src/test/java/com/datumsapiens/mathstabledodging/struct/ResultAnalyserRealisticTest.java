package com.datumsapiens.mathstabledodging.struct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ResultAnalyserRealisticTest {

    private ArrayList<QuestionAnswerData> listOfQuestionsAnswers;
    private StartParams startParams;
    private static final Long ONE = 1l;

    @BeforeEach
    public void init() {
        startParams = new StartParams(99, "JUNIT", 5000);
        Integer sequenceNum = 0;

        listOfQuestionsAnswers = new ArrayList<>();

        for (int tableCounter = 2; tableCounter <= startParams.getTablesTo() + 1; tableCounter++) {
            for (int multiplier = 1; multiplier <= 20; multiplier++) {
                Question question1 = new Question(tableCounter, multiplier);
                Integer result = tableCounter * multiplier;
                Answer answer1 = new Answer(result, result, ONE);
                if (tableCounter == 5 && multiplier == 5) {
                    listOfQuestionsAnswers.add(new QuestionAnswerData(sequenceNum++, question1, new Answer(10, result, ONE)));

                } else {
                    listOfQuestionsAnswers.add(new QuestionAnswerData(sequenceNum++, question1, answer1));
                }
            }
        }

        System.out.println("Before called");

    }

    @Test
    void analyze() {
        assertTrue(listOfQuestionsAnswers.size() == 1980);
        ResultOfDodgingGame resultOfDodgingGame = new ResultOfDodgingGame(startParams, listOfQuestionsAnswers);
        AnalysedData analysedData = new ResultAnalyser(resultOfDodgingGame).analyze();
        System.out.println("getNumTables: " + analysedData.getNumTables());
        assertTrue(analysedData.getQuestionsAskedForTable().length == 101);
        assertTrue(analysedData.getQuestionsAnsweredCorrectlyForTable().length == 101);
        assertTrue(analysedData.getTableTimeTakenToAnswerForTable().length == 101);
        for (int counter = 2; counter < 101; counter++) {
            assertTrue(analysedData.getQuestionsAskedForTable(counter) == 20);
            if (counter == 5) {
                assertTrue(analysedData.getQuestionsAnsweredCorrectlyForTable(counter) == 19);
            } else {
                assertTrue(analysedData.getQuestionsAnsweredCorrectlyForTable(counter) == 20);
            }
            assertTrue(Double.valueOf(analysedData.getTableTimeTakenToAnswerForTable(counter)).intValue() == 20);
        }
        assertTrue(analysedData.getTotalQuestionsAsked() == 1980);
        assertTrue(analysedData.getTotalQuestionsCorrect() == 1979);

    }
}