package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;

import java.util.List;

public class LockerRobotManager extends PrimaryLockerRobot {

    private List<LockerRobot> lockerRobots;

    public LockerRobotManager(List<Locker> lockers, List<LockerRobot> lockerRobots) {
        super(lockers);
        this.lockerRobots = lockerRobots;
    }

    public Ticket store(Bag myBag) {
        for (LockerRobot lockerRobot : lockerRobots) {
            if (lockerRobot.isAvailable()) {
                return lockerRobot.store(myBag);
            }
        }
        return super.store(myBag);
    }

    public Bag pickUp(Ticket ticket){
        for (LockerRobot lockerRobot:lockerRobots){
            if (lockerRobot.isValid(ticket)){
                return lockerRobot.pickUp(ticket);
            }
        }
        return super.pickUp(ticket);
    }
}
