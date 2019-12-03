package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.StartParams;

import java.util.Scanner;

import static com.datumsapiens.mathstabledodging.struct.StartParams.QUESTIONS;
import static com.datumsapiens.mathstabledodging.struct.StartParams.QUESTION_KEYS;

public class Starter {
    private static final Integer GAME_START_DELAY_SECS = 3;

    // TODO: Validate input
    public StartParams receiveStartParams() {
        prequel();
        Scanner scan = new Scanner(System.in);
        Integer tablesFrom = 2;
        Integer tablesTo = 9;
        String playerName = "Somebody";
        Integer numQuestions = 10;
        for (QUESTION_KEYS keys : QUESTION_KEYS.values()) {
            String response = "";
            switch (keys) {

                case TABLE_TO:
                    System.out.println(QUESTIONS.get(QUESTION_KEYS.TABLE_TO));
                    response = scan.nextLine();
                    tablesTo = Integer.valueOf(response);
                    break;
                case PLAYER_NAME:
                    System.out.println(QUESTIONS.get(QUESTION_KEYS.PLAYER_NAME));
                    response = scan.nextLine();
                    playerName = response;
                    break;
                case NUM_QUESTIONS:
                    System.out.println(QUESTIONS.get(QUESTION_KEYS.NUM_QUESTIONS));
                    response = scan.nextLine();
                    numQuestions = Integer.valueOf(response);
                    break;
            }
        }
        StartParams startParams = new StartParams(tablesTo, playerName, numQuestions);
        System.out.println(startParams);
        return startParams;
    }

    private void prequel() {
        System.out.println("REM: Press '/' key to skip a question.");
        System.out.print("Starting Challenge in seconds...");

        try {
            for (Integer secs = GAME_START_DELAY_SECS; secs >= 0; secs--) {
                Thread.sleep(1000);
                System.out.print(" " + secs + " . ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
