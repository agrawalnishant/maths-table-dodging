package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GameRunner {
    private StartParams startParams;
    private ArrayList<QuestionAnswerData> listOfQuestionAnswers;
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public GameRunner(final StartParams startParams) {
        this.startParams = startParams;
        this.listOfQuestionAnswers = new ArrayList<QuestionAnswerData>(startParams.getNumQuestions());
    }

    public ResultOfDodgingGame start() {
        return new ResultOfDodgingGame(startParams, runTheGame());
    }

    private ArrayList<QuestionAnswerData> runTheGame() {
        QuestionGenerator questionGenerator = new SimpleQuestionGenerator(startParams);
        int numQuestions = startParams.getNumQuestions();
        while (numQuestions-- > 0) {
            Question question = questionGenerator.generateNextQuestion();
            Integer questionNumber = atomicInteger.getAndIncrement();
            Answer answer = question.ask(questionNumber);
            QuestionAnswerData questionAnswerData = new QuestionAnswerData(questionNumber, question, answer);
            listOfQuestionAnswers.add(questionAnswerData);
        }
        return listOfQuestionAnswers;
    }
}
