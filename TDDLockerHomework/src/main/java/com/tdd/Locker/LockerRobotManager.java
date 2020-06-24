package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;

import java.util.List;

public class LockerRobotManager extends LockerRobot {

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
        throw new NoRoomException();
    }
}
