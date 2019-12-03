package com.datumsapiens.mathstabledodging;

import com.datumsapiens.mathstabledodging.orchestrator.Orchestrator;

public class DodgingGame {

    public static void main(String[] args) {
        System.out.println("Welcome!");
        new DodgingGame().start();
    }

    public void start() {
        Orchestrator.orchestrate();
    }

}
