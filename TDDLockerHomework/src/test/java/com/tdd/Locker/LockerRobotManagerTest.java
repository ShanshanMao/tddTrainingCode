package com.tdd.Locker;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class LockerRobotManagerTest {

    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_manager_robot_manage_two_lockers_and_both_not_full(){
        Locker firstlocker = new Locker(2);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstlocker,new Locker(2)));
        Bag myBag = new Bag();

        Ticket ticket = lockerRobotManager.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstlocker.pickUp(ticket));
    }
}
