package com.tdd.Locker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class SmartLockerRobot {
    private final List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {

        Optional<Locker> maxCapacity = lockers.stream().max(Comparator.comparing(Locker::getCapacity));
        return maxCapacity.map(locker -> locker.store(bag)).orElse(null);
    }
}