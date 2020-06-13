package com.tdd.Locker;

/**
 * created by ssmao on 20200613
 */
public class Locker {
    private int LockerUsedCount;
    private int LockerCount;

    public Locker(int LockerCount) {
        this.LockerCount = LockerCount;
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

    }

