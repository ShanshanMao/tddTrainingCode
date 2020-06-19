package com.tdd.Locker;

import java.util.List;

public class SmartLockerRobot {
    private final List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        return lockers.get(0).store(bag);
    }
}
