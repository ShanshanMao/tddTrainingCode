package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class SmartLockerRobot extends LockerRobot{
    public SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    public Ticket store(Bag bag) {
        lockers.sort(Comparator.comparing(Locker::getValidCapacity).reversed());
        if (!lockers.isEmpty() && lockers.get(0).getValidCapacity() > 0) {
            return lockers.get(0).store(bag);
        }
        throw new NoRoomException("locker is full");
    }
}
