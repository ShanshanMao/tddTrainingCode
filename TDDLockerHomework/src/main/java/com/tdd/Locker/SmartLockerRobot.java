package com.tdd.Locker;

import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;

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
        if ((maxCapacity.isPresent())){
            return maxCapacity.get().store(bag);
        }
        throw new NoRoomException();
    }

    public Bag pickUp(Ticket ticket) {
        for (Locker locker:lockers){
            if (locker.contains(ticket)){
                return locker.pickUp(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}