package com.locker;

import com.sun.corba.se.impl.orbutil.LogKeywords;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;

public class LockerRobotManagerTest {
    @Test
    public void should_return_a_ticket_and_store_in_1st_locker_when_LockerRobotManager_have_2_locker_with_available_capacity_and_no_robot() {
        Locker firstLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, new Locker(1)));
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag, firstLocker.pickUp(ticket));
    }

    @Test
    public void should_return_a_ticket_and_store_in_2nd_locker_when_LockerRobotManager_have_1_full_locker_1_available_capacity_locker_and_no_robot(){
        Locker firstLocker = new Locker(1);
        firstLocker.store(new Bag());
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker));
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,secondLocker.pickUp(ticket));
    }
}
