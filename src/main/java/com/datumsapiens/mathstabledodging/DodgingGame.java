package com.datumsapiens.mathstabledodging;

import com.datumsapiens.mathstabledodging.orchestrator.GameRunner;
import com.datumsapiens.mathstabledodging.orchestrator.Starter;
import com.datumsapiens.mathstabledodging.struct.ResultOfDodgingGame;
import com.datumsapiens.mathstabledodging.struct.StartParams;

import java.util.concurrent.atomic.AtomicInteger;

public class DodgingGame {
    private static final Integer GAME_START_DELAY_SECS = 3;
    private static AtomicInteger gameCounter;
    private StartParams startParams;

    public void start(final StartParams startParams) {
        this.startParams = startParams;
        ResultOfDodgingGame resultOfDodgingGame = new GameRunner(startParams).start();
        resultOfDodgingGame.show();
    }

    public static void main(String[] args) {
        System.out.print("Starting Challenge in seconds...");

        try {
            for (Integer secs = GAME_START_DELAY_SECS; secs >= 0; secs--) {
                Thread.sleep(1000);
                System.out.print(" " + secs + " . ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("");
        StartParams startParams = Starter.receiveStartParams();

        DodgingGame dodgingGame = new DodgingGame();
        dodgingGame.start(startParams);

    }

}
