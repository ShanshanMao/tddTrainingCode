package com.locker;

import com.locker.exception.InvalidTicketException;
import com.locker.exception.NoRoomException;

import java.util.*;

public class PrimaryLockerRobot {
    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers){
        this.lockers = lockers;
    }

    public Ticket store(Bag bag){
        for (Locker locker : lockers){
            if (!locker.isFull()){
                return locker.store(bag);
            }
        }
        throw new NoRoomException();
    }

    public Bag pickUp(Ticket ticket) {
       for (Locker locker : lockers){
           if(locker.contains(ticket)){
               return locker.pickUp(ticket);
           }
       }
       throw new InvalidTicketException();
    }
}
