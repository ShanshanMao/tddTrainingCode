package com.locker;

import com.locker.exception.NoRoomException;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class LockerRobotManager {
    public List<Locker> lockers;
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
