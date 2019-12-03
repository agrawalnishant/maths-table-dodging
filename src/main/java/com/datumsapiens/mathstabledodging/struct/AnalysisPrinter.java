package com.datumsapiens.mathstabledodging.struct;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AnalysisPrinter {
    final AnalysedData analysedData;

    public AnalysisPrinter(final AnalysedData analysedData) {
        this.analysedData = analysedData;
    }

    public void showAnalysis() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(ResultOfDodgingGame.DATAFILE, true));
            writer.append("\n\n Analysis: \n");
            Integer numTables = analysedData.getNumTables() + 1;
            while (numTables-- > 2) {
                if (analysedData.getQuestionsAskedForTable(numTables) > 0) {
                    String msg = "";
                    if (analysedData.getQuestionsAnsweredCorrectlyForTable(numTables) != analysedData.getQuestionsAskedForTable(numTables)) {
                        msg += " !! Need to revise ";
                    }
                    msg += ("Table of " + numTables + " -  " + analysedData.getQuestionsAnsweredCorrectlyForTable(numTables)
                            + " Correct out of total " + analysedData.getQuestionsAskedForTable(numTables)
                            + ".  Avg. Time: " + (analysedData.getTableTimeTakenToAnswerForTable(numTables) / (1.0 * analysedData.getQuestionsAskedForTable(numTables)))
                            + " seconds.");
                    System.out.println(msg);
                    writer.append("\n" + msg);

                }
            }
            String msg = "\n\t ** Final Marks: " + analysedData.getTotalQuestionsCorrect() + " / " + analysedData.getTotalQuestionsAsked() + " *** \n";
            System.out.println(msg);
            writer.append(msg);
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