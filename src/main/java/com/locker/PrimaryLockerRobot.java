package com.locker;

import com.locker.exception.InvalidTicketException;
import com.locker.exception.NoRoomException;

import java.util.List;

class PrimaryLockerRobot extends Robot {
    private final List<Locker> lockers;

    PrimaryLockerRobot(List<Locker> lockers){
        this.lockers = lockers;
    }

    @Override
    public Ticket store(Bag bag){
        for (Locker locker : lockers){
            if (!locker.isFull()){
                return locker.store(bag);
            }
        }
        throw new NoRoomException();
    }

    @Override
    public Bag pickUp(Ticket ticket) {
       for (Locker locker : lockers){
           if(locker.contains(ticket)){
               return locker.pickUp(ticket);
           }
       }
       throw new InvalidTicketException();
    }

    boolean containsBag(Bag myBag) {
        for (Locker locker : lockers) {
            if (locker.containsBag(myBag)) {
                return true;
            }
        }
        return false;
    }
}
