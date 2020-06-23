package com.locker;

import com.locker.exception.InvalidTicketException;
import com.locker.exception.NoRoomException;

import java.util.*;

class PrimaryLockerRobot {
    private final List<Locker> lockers;

    PrimaryLockerRobot(List<Locker> lockers){
        this.lockers = lockers;
    }

    Ticket store(Bag bag){
        for (Locker locker : lockers){
            if (!locker.isFull()){
                return locker.store(bag);
            }
        }
        throw new NoRoomException();
    }

    Bag pickUp(Ticket ticket) {
       for (Locker locker : lockers){
           if(locker.contains(ticket)){
               return locker.pickUp(ticket);
           }
       }
       throw new InvalidTicketException();
    }
}
