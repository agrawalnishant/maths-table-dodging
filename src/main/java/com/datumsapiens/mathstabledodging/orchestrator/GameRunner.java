package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.QuestionAnswerData;
import com.datumsapiens.mathstabledodging.struct.ResultOfDodgingGame;
import com.datumsapiens.mathstabledodging.struct.StartParams;

public class GameRunner {
    private StartParams startParams;

    public GameRunner(final StartParams startParams) {
        this.startParams = startParams;
    }

    public ResultOfDodgingGame start() {
        return new ResultOfDodgingGame(runTheGame());
    }

    private QuestionAnswerData runTheGame() {
        return null;
    }
}
