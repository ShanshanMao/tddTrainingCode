package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class SmartLockerRobot extends LockerRobot{
    public SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    public Ticket store(Bag bag) {

        Optional<Locker> maxCapacity = lockers.stream().max(Comparator.comparing(Locker::getCapacity));
        if ((maxCapacity.isPresent())){
            return maxCapacity.get().store(bag);
        }
        throw new NoRoomException();
    }
}