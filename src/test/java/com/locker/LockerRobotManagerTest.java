package com.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
}
