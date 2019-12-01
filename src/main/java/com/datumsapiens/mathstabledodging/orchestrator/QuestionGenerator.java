package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.Question;
import com.datumsapiens.mathstabledodging.struct.StartParams;

public interface QuestionGenerator {
    default Question get(final StartParams startParams) {
        return new SimpleQuestionGenerator(startParams).generateNextQuestion();
    }

    Question generateNextQuestion();
}
