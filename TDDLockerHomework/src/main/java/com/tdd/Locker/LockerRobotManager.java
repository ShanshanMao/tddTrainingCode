package com.tdd.Locker;

import java.util.List;

public class LockerRobotManager extends PrimaryLockerRobot{
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

    public Bag pickUp(Ticket ticket) {
        for (LockerRobot lockerRobot : lockerRobots) {
            if (lockerRobot.isValid(ticket)) {
                return lockerRobot.pickUp(ticket);
            }
        }
        return super.pickUp(ticket);
    }

    public int getValidCapacity() {
        int lockersValidCapacity = lockers.stream().mapToInt(Locker::getValidCapacity).sum();
        int robotsValidCapacity = lockerRobots.stream().mapToInt(LockerRobot::getValidCapacity).sum();
        return lockersValidCapacity + robotsValidCapacity;
    }

    public int getAllCapacity() {
        int lockersAllCapacity = lockers.stream().mapToInt(Locker::getAllCapacity).sum();
        int robotsAllCapacity = lockerRobots.stream().mapToInt(LockerRobot::getAllCapacity).sum();
        return lockersAllCapacity + robotsAllCapacity;
    }

    public String getReport() {
        String report = "M " + getValidCapacity() + " " + getAllCapacity()+ "\n";
        report = lockers.isEmpty()?report:lockers.stream().map(Locker::getReport)
                .reduce(report,(partialReport,lockerReport)->partialReport + lockerReport);
        return lockerRobots.isEmpty()?report:lockerRobots.stream().map(LockerRobot::getReport)
                .reduce(report,(partialReport,robotReport)->partialReport + robotReport);
    }

    public boolean isValid(Ticket ticket) {
        return lockers.stream().anyMatch(locker -> locker.contains(ticket));
    }
}
