package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.ResultOfDodgingGame;
import com.datumsapiens.mathstabledodging.struct.StartParams;

public class Orchestrator {

    public static void orchestrate() {

        StartParams startParams = new Starter().receiveStartParams();
        ResultOfDodgingGame resultOfDodgingGame = new GameRunner(startParams).start();
        resultOfDodgingGame.show();
        resultOfDodgingGame.showAnalysis();
    }
}
