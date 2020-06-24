package com.locker;

import com.locker.exception.InvalidTicketException;
import com.locker.exception.NoRoomException;

import java.util.List;

public class LockerRobotManager {
    public List<Locker> lockers;
    public List<Robot> robots;

    public LockerRobotManager(List<Locker> lockers, List<Robot> robots) {
        this.lockers = lockers;
        this.robots = robots;
    }

    public Ticket store(Bag myBag) {
        for (Robot robot : robots) {
            try {
                return robot.store(myBag);
            } catch (NoRoomException e) {
                continue;
            }
        }

        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.store(myBag);
            }
        }
        throw new NoRoomException();
    }

    public Bag pickUp(Ticket ticket) {
        for (Robot robot : robots) {
            try {
                return robot.pickUp(ticket);
            } catch ( InvalidTicketException e) {
                continue;
            }
        }

        for (Locker locker : lockers) {
            return locker.pickUp(ticket);
        }
        throw new InvalidTicketException();
    }
}
