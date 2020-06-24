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
                return new ManagerTicket(robot.store(myBag));
            } catch (NoRoomException e) {
                continue;
            }
        }

        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return new ManagerTicket(locker.store(myBag));
            }
        }
        throw new NoRoomException();
    }

    public Bag pickUp(Ticket ticket) {
        if (ticket instanceof ManagerTicket) {
            for (Robot robot : robots) {
                try {
                    return robot.pickUp(((ManagerTicket) ticket).getTicket());
                } catch ( InvalidTicketException e) {
                    continue;
                }
            }

            for (Locker locker : lockers) {
                return locker.pickUp(((ManagerTicket) ticket).getTicket());
            }
            throw new InvalidTicketException();
        }
        throw new InvalidTicketException();
    }
}
