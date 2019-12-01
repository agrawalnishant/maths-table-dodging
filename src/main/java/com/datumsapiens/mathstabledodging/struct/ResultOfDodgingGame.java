package com.datumsapiens.mathstabledodging.struct;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ListIterator;

public class ResultOfDodgingGame {
    private static final String DATAFILE = "./DODGING_RECORD.txt";
    private StartParams startParams;
    private ArrayList<QuestionAnswerData> listOfQuestionsAnswers;
    private int[] tableQuestionsAsked;
    private int[] tableQuestionsAnswered;
    private double[] tableTimeTaken;

    public ResultOfDodgingGame(final StartParams startParams, final ArrayList<QuestionAnswerData> listOfQuestionsAnswers) {
        this.startParams = startParams;
        this.listOfQuestionsAnswers = listOfQuestionsAnswers;
        Integer numTables = startParams.getTablesTo() + 1;
        tableQuestionsAsked = new int[numTables + 1];
        tableQuestionsAnswered = new int[numTables + 1];
        tableTimeTaken = new double[numTables + 1];
    }

    public void show() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(DATAFILE, true));
            writer.append("\n \n" + "At time:" + startParams.getTime().truncatedTo(ChronoUnit.MINUTES) + " \t" + startParams + " \n");
            ListIterator<QuestionAnswerData> qIterator = listOfQuestionsAnswers.listIterator();
            while (qIterator.hasNext()) {
                QuestionAnswerData qAns = qIterator.next();
                String msg = "Q" + qAns.getSequenceNum() + " :\t " + qAns.getAnswer().getResult() + qAns.getQuestion() + qAns.getAnswer();
                System.out.println(msg);
                writer.append("\n" + msg);
            }
            System.out.println("\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void showAnalysis() {
        ListIterator<QuestionAnswerData> qIterator = listOfQuestionsAnswers.listIterator();
        while (qIterator.hasNext()) {
            QuestionAnswerData qAns = qIterator.next();
            Question ques = qAns.getQuestion();
            Answer answer = qAns.getAnswer();
            Integer index = ques.getTable();
            tableQuestionsAsked[index] += 1;
            tableQuestionsAnswered[index] += (answer.getResult().equals(Result.CORRECT) ? 1 : 0);
            tableTimeTaken[index] += (1.0 * answer.getTimeTaken());
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(DATAFILE, true));
            writer.append("\n\n Analysis: \n");
            Integer numTables = startParams.getTablesTo() + 1;
            while (numTables-- > 2) {
                if (tableQuestionsAsked[numTables] > 0) {
                    String msg = "";
                    if (tableQuestionsAnswered[numTables] != tableQuestionsAsked[numTables]) {
                        msg += " !! Need to revise ";
                    }
                    msg += ("Table of " + numTables + " -  " + tableQuestionsAnswered[numTables]
                            + " Correct out of total " + tableQuestionsAsked[numTables]
                            + ".  Avg. Time: " + (tableTimeTaken[numTables] / (1.0 * tableQuestionsAsked[numTables])) + " seconds.");
                    System.out.println(msg);
                    writer.append("\n" + msg);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
