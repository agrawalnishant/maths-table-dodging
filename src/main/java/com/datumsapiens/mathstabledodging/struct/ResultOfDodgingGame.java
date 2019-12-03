package com.datumsapiens.mathstabledodging.struct;

import lombok.Value;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ListIterator;

@Value
public class ResultOfDodgingGame {
    static final String DATAFILE = "./DODGING_RECORD.txt";

    private StartParams startParams;
    private ArrayList<QuestionAnswerData> listOfQuestionsAnswers;

    public ResultOfDodgingGame(final StartParams startParams, final ArrayList<QuestionAnswerData> listOfQuestionsAnswers) {
        this.startParams = startParams;
        this.listOfQuestionsAnswers = listOfQuestionsAnswers;
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

}
