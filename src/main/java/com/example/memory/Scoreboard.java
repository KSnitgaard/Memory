package com.example.memory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Scoreboard {
    private int counterTræk;
    private int counterPair;

    public Scoreboard() {
        this.counterTræk = 0;
        this.counterPair = 0;
    }

    public void incrementTotalGuesses() {
        counterTræk++;
    }

    public void incrementCorrectMatches() {
        counterPair++;
    }

    public int getTotalGuesses() {
        return counterTræk;
    }

    public int getCorrectMatches() {
        return counterPair;
    }

}

