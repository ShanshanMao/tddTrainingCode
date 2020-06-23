package com.locker;

import com.locker.exception.InvalidTicketException;
import com.locker.exception.NoRoomException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


class SmartLockerRobot {
    private final List<Locker> lockers;

    SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    Ticket store(Bag bag) {

        Optional<Locker> maxCapacity = lockers.stream().max(Comparator.comparing(Locker::getAvailableCapacity));
        if ((maxCapacity.isPresent())){
            return maxCapacity.get().store(bag);
        }
        throw new NoRoomException();
    }

    Bag pickUp(Ticket ticket) {
        for (Locker locker:lockers){
            if (locker.contains(ticket)){
                return locker.pickUp(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}