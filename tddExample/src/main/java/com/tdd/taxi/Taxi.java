package com.tdd.taxi;

public class Taxi {

    private static final double UNIT_PRICE = 0.8;

    public double calculate(int distance) {
        return UNIT_PRICE * distance ;
    }
}
