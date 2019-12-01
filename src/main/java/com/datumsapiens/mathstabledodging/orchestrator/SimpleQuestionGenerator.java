package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.Question;
import com.datumsapiens.mathstabledodging.struct.StartParams;

import java.util.Random;

public class SimpleQuestionGenerator implements QuestionGenerator {

    private final StartParams startParams;

    public SimpleQuestionGenerator(final StartParams startParams) {
        this.startParams = startParams;
    }

    @Override
    public Question generateNextQuestion() {
        Integer randomTable = nextRandom(startParams.getTablesTo() + 1);
        Integer randomMultiplier = nextRandom(10);
        return new Question(randomTable, randomMultiplier);
    }

    private static Integer nextRandom(final int bound) {
        Integer rndNum = (new Random().nextInt(bound) + 1) % bound;
        while (rndNum == 0 || rndNum == 1 || rndNum > bound) {
            //rndNum = (new Random().nextInt(bound)) % bound;
            rndNum = rndNum == 0 || rndNum == 1 ? ((new Random().nextInt(bound)) % bound) : rndNum;
        }
        return rndNum == 0 || rndNum == 1 ? bound : rndNum;
    }
}
