package com.viraj.snake_ladder.model;

import java.util.Random;

public class Dice {
    private final int maxValue;
    Random random = new Random();

    public Dice() {
        this.maxValue = 6;
    }
    public Dice(int maxValue) {
        this.maxValue = maxValue;
    }

    public int roll(){
        return random.nextInt(1 , maxValue + 1);
    }
}