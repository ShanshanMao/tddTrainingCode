package com.tdd.Locker;

import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;
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
            throw new NoRoomException("locker is full");
        }
        Ticket ticket = new Ticket();
        bagMap.put(ticket, bag);
        return ticket;
    }

    public Bag pickUp(Ticket ticket) {
        if (!contains(ticket)) {
            throw new InvalidTicketException();
        }
        return bagMap.remove(ticket) ;
    }


    public boolean isFull() {
        return size ==0;
    }

    public boolean contains(Ticket ticket){
        return bagMap.containsKey(ticket);
    }

    public  int getValidCapacity() {
        return size - bagMap.size();
    }

    public boolean isAvailable() {
        return getValidCapacity()>0;
    }

    public Bag find(Ticket ticket) {
        return bagMap.get(ticket);
    }
}

