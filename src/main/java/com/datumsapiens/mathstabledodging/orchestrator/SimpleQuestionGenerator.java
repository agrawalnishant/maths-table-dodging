package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.Question;
import com.datumsapiens.mathstabledodging.struct.StartParams;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleQuestionGenerator implements QuestionGenerator {

    private final StartParams startParams;

    public SimpleQuestionGenerator(final StartParams startParams) {
        this.startParams = startParams;
    }

    @Override
    public Question generateNextQuestion() {
        Integer randomTable = ThreadLocalRandom.current().nextInt(2, startParams.getTablesTo() + 1);
        Integer randomMultiplier = ThreadLocalRandom.current().nextInt(2, 10);
        return new Question(randomTable, randomMultiplier);
    }
}
