package com.taxi;

class Taxi {

    private static final double UNIT_PRICE = 0.8;

    double calculate(int distance) {
        return UNIT_PRICE * distance ;
    }
}
