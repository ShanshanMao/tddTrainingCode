package com.tdd.Locker;

import com.tdd.Locker.exception.InvalidTicketException;

import java.util.List;

public abstract class LockerRobot {
    protected List<Locker> lockers;

    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Bag pickUp(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.contains(ticket)) {
                return locker.pickUp(ticket);
            }
        }

        throw new InvalidTicketException();
    }

    public abstract Ticket store(Bag myBag);

    public  boolean isAvailable(){
        return lockers.stream().anyMatch(Locker::isAvailable);
    }
}
