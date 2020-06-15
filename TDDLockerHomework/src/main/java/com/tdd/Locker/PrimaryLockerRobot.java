package com.tdd.Locker;


import java.util.List;


public class PrimaryLockerRobot {
    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers){
        this.lockers = lockers;
    }

    public Ticket store(Bag myBag){
        if (lockers.get(0).isFull()){
            return lockers.get(1).store(myBag);
        }
        return null;
    }


}
