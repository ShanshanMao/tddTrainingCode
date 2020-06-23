package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;

import java.util.List;

public class LockerRobotManager {
    private final List<Locker> lockers;

    public LockerRobotManager(List<Locker> lockers) {
        this.lockers = lockers;

    }

    public Ticket store(Bag myBag) {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.store(myBag);
            }
        }
        throw new NoRoomException();
    }

}
