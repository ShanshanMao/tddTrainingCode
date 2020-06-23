package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;

import java.util.*;

public class PrimaryLockerRobot extends LockerRobot{
    public PrimaryLockerRobot(List<Locker> lockers){
        super(lockers);
    }

    public Ticket store(Bag myBag){
        for (Locker locker : lockers){
            if (!locker.isFull()){
                return locker.store(myBag);
            }
        }
        throw new NoRoomException();
    }
}
