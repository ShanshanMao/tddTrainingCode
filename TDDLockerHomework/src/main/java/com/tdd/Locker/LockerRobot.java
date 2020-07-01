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

    public boolean isValid(Ticket ticket){
        return lockers.stream().anyMatch(locker -> locker.contains(ticket));
    }

    public boolean isAvailable(){
        return lockers.stream().anyMatch(Locker::isAvailable);
    }

    public int getValidCapacity(){
        return lockers.stream().mapToInt(Locker::getValidCapacity).sum();
    }

    public int getAllCapacity(){
        return lockers.stream().mapToInt(Locker::getAllCapacity).sum();
    }

    public String getReport(){
        String report = "\tR " + getValidCapacity()+" "+getAllCapacity()+"\n";
        return lockers.stream().map(Locker::getReport).reduce(report,(partialReport,lockerReport)->partialReport+"\t"+ lockerReport);
    }
}