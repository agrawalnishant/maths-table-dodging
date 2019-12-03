package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.*;

public class Orchestrator {

    public static void orchestrate() {

        StartParams startParams = new Starter().receiveStartParams();
        ResultOfDodgingGame resultOfDodgingGame = new GameRunner(startParams).start();
        resultOfDodgingGame.show();
        AnalysedData analysedData = new ResultAnalyser(resultOfDodgingGame).analyze();
        AnalysisPrinter analysisPrinter = new AnalysisPrinter(analysedData);
        analysisPrinter.showAnalysis();
    }
}
