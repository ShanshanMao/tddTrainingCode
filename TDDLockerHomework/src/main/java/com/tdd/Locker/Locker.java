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
    private List<String> illegalTicket;

    public Locker(int LockerCount) {
        this.LockerCount = LockerCount;
        this.illegalTicket = new ArrayList<String>();
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
        repeatTickets.add(ticket);
        LockerUsedCount++;

        return ticket;
        }

    public boolean get(String ticket){

        if (!repeatTickets.contains(ticket)) {
            throw new pickPackageFailException("Failed to collect the parcel, the ticket have been used！");
        }
        if (illegalTicket.contains(ticket) ){
            throw new pickPackageFailException("Failed to collect the package, the ticket is illegal! ");
        }
        illegalTicket.add(ticket);

        return true;
    }

}

