package com.tdd.Locker;

import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;
import lombok.var;
import java.util.HashMap;
import java.util.Map;

/**
 * created by ssmao on 20200613
 */
public class Locker {
    private int size;
    private Map<Ticket, Bag> bagMap = new HashMap<>();

    public Locker(int size) {
        this.size = size;
    }

    public Ticket store(Bag bag) {
        if (isFull()){
            throw new NoRoomException("The locker is full");
        }
        var ticket = new Ticket();
        bagMap.put(ticket, bag);
        return ticket;
    }

    public Bag pickUp(Ticket ticket) {
        if (!bagMap.containsKey(ticket)) {
            throw new InvalidTicketException("The ticket is invalid");
        }
        var bag = bagMap.get(ticket);
        bagMap.remove(ticket);
        return bag;
    }


    public boolean isFull() {
        return bagMap.size() == size;

    }
}

