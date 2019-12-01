package com.datumsapiens.mathstabledodging.orchestrator;

import com.datumsapiens.mathstabledodging.struct.StartParams;

import java.util.Scanner;

import static com.datumsapiens.mathstabledodging.struct.StartParams.QUESTIONS;
import static com.datumsapiens.mathstabledodging.struct.StartParams.QUESTION_KEYS;

public class Starter {

    // TODO: Validate input
    public static StartParams receiveStartParams() {
        Scanner scan = new Scanner(System.in);
        Integer tablesFrom = 2;
        Integer tablesTo = 9;
        String playerName = "Somebody";
        Integer numQuestions = 10;
        for (QUESTION_KEYS keys : QUESTION_KEYS.values()) {
            String response = "";
            switch (keys) {

                case TABLE_FROM:
                    System.out.println(QUESTIONS.get(QUESTION_KEYS.PLAYER_NAME));
                    response = scan.nextLine();
                    playerName = new String(response != null && response.length() > 0 ? response.trim() : "Someone");
                    break;
                case TABLE_TO:
                    System.out.println(QUESTIONS.get(QUESTION_KEYS.TABLE_FROM));
                    response = scan.nextLine();
                    tablesFrom = Integer.valueOf(response);
                    break;
                case PLAYER_NAME:
                    System.out.println(QUESTIONS.get(QUESTION_KEYS.TABLE_TO));
                    response = scan.nextLine();
                    tablesTo = Integer.valueOf(response);
                    break;
                case NUM_QUESTIONS:
                    System.out.println(QUESTIONS.get(QUESTION_KEYS.NUM_QUESTIONS));
                    response = scan.nextLine();
                    numQuestions = Integer.valueOf(response);
                    break;
            }
        }
        StartParams startParams = new StartParams(tablesFrom, tablesTo, playerName, numQuestions);
        System.out.println(startParams);
        return startParams;
    }
}
