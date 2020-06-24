package com.locker;

import com.locker.exception.InvalidTicketException;
import com.locker.exception.NoRoomException;

import java.util.HashMap;
import java.util.Map;

/**
 * created by ssmao on 20200613
 */
class Locker {
    private int initCapacity;
    private Map<Ticket, Bag> bagMap = new HashMap<>();

    Locker(int initCapacity) {
        this.initCapacity = initCapacity;
    }

    Ticket store(Bag bag) {
        if (getAvailableCapacity() <= 0) {
            throw new NoRoomException();
        }
        Ticket ticket = new Ticket();
        bagMap.put(ticket, bag);
        return ticket;
    }

    Bag pickUp(Ticket ticket) {
        if (!bagMap.containsKey(ticket)) {
            throw new InvalidTicketException();
        }
        Bag bag = bagMap.get(ticket);
        bagMap.remove(ticket);
        return bag;
    }


    boolean isFull() {
        return initCapacity - bagMap.size() <= 0;
    }

    boolean contains(Ticket ticket) {
        return bagMap.containsKey(ticket);
    }

    boolean containsBag(Bag myBag) {
        return bagMap.containsValue(myBag);
    }

    int getAvailableCapacity() {
        return initCapacity - bagMap.size();
    }
}

