package com.tdd.Locker;


import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;
import lombok.var;

import java.util.*;
import java.util.function.Supplier;


public class PrimaryLockerRobot {
    private final List<Locker> lockers;
    private Map<Ticket, Bag> bagMap = new HashMap<>();

    public PrimaryLockerRobot(List<Locker> lockers){
        this.lockers = lockers;
    }

    public Ticket store(Bag myBag) throws Throwable {
        Locker hadSizeStoreLocker = lockers.stream()
                .filter(lockers -> !lockers.isFull())
                .findFirst()
                .orElseThrow((Supplier<Throwable>) NoRoomException::new);

        return hadSizeStoreLocker.store(myBag);
    }

    public Bag pickUp(Ticket ticket) {
        if (!bagMap.containsKey(ticket)) {
            throw new InvalidTicketException("The ticket is invalid");
        }
        var bag = bagMap.get(ticket);
        bagMap.remove(ticket);
        return bag;
    }
}
