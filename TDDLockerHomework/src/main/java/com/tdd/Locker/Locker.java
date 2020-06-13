package com.tdd.Locker;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ssmao on 20200613
 */
public class Locker {
    private List<String> repeatTickets;
    private int LockerUsedCount;
    private int LockerCount;
    private List<String> tickets;

    public Locker(int LockerCount) {
        this.LockerCount = LockerCount;
        this.tickets = new ArrayList<String>();
        this.repeatTickets = new ArrayList<String>();
    }

    public void setUsedCount(int LockerUsedCount) {
        this.LockerUsedCount = LockerUsedCount;
    }

    public String save()  {
        if (LockerUsedCount >= LockerCount){
            throw new SavePackageFailException("Lockers are fulled,save package failure!");
        }

        String ticket = "010";
        LockerUsedCount++;

        return ticket;
        }

    public boolean get(String ticket){

        if (repeatTickets.contains(ticket)) {
            throw new pickPackageFailException("Failed to collect the parcel, the ticket have been used！");
        }
        repeatTickets.add(ticket);

        return true;

    }

    }

