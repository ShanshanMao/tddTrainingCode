package com.tdd.Locker;

import java.util.List;

public class LockerRobotManager {
    private final List<Locker> lockers;

    public LockerRobotManager(List<Locker> lockers) {
        this.lockers = lockers;

    }

    public Ticket store(Bag myBag) {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                return locker.store(myBag);
            }
        }
        return null;
    }

}
