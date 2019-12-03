package com.datumsapiens.mathstabledodging.struct;

import java.util.ListIterator;

public class ResultAnalyser {
    private final ResultOfDodgingGame resultOfDodgingGame;

    public ResultAnalyser(ResultOfDodgingGame resultOfDodgingGame) {
        this.resultOfDodgingGame = resultOfDodgingGame;
    }

    public AnalysedData analyze() {
        StartParams startParams = resultOfDodgingGame.getStartParams();
        ListIterator<QuestionAnswerData> qIterator = resultOfDodgingGame.getListOfQuestionsAnswers().listIterator();
        Integer numTables = startParams.getTablesTo() + 1;
        AnalysedData analysedData = new AnalysedData(numTables, new int[numTables + 1], new int[numTables + 1], new double[numTables + 1], 0, 0);
        while (qIterator.hasNext()) {
            QuestionAnswerData qAns = qIterator.next();
            Question ques = qAns.getQuestion();
            Answer answer = qAns.getAnswer();
            Integer index = ques.getTable();
            analysedData.IncrementTableQuestionsAskedBy(index, 1);
            analysedData.IncrementTableQuestionsAnsweredBy(index, (answer.getResult().equals(Result.CORRECT) ? 1 : 0));
            analysedData.IncrementTableTimeTakenBy(index, (1.0 * answer.getTimeTaken()));
        }

        return analysedData;
    }
}