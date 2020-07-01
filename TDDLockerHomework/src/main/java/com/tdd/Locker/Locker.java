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
        if (bagMap.size()>=size){
            throw new NoRoomException("locker is full");
        }
        Ticket ticket = new Ticket();
        bagMap.put(ticket, bag);
        return ticket;
    }

    public Bag pickUp(Ticket ticket) {
        Bag bag = bagMap.get(ticket);
        if (bagMap.get(ticket) != null) {
            bagMap.remove(ticket);
            return bag;
        }
        throw new InvalidTicketException();
    }

    public boolean contains(Ticket ticket){
        return bagMap.get(ticket) != null;
    }

    public  int getValidCapacity() {
        return size - bagMap.size();
    }

    public boolean isAvailable() { return getValidCapacity()>0; }

    public Bag find(Ticket ticket) {
        return bagMap.get(ticket);
    }

    public int getAllCapacity() {
        return size;
    }

    public String getReport(){
        return "\tL " + getValidCapacity()+" "+ size +"\n";
    }
}

