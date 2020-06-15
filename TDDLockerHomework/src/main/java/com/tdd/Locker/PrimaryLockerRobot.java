package com.tdd.Locker;


import com.tdd.Locker.exception.NoRoomException;

import java.util.List;
import java.util.function.Supplier;


public class PrimaryLockerRobot {
    private final List<Locker> lockers;

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


}
