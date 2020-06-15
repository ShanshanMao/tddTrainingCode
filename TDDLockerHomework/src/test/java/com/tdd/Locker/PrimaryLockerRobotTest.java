package com.tdd.Locker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrimaryLockerRobotTest {
    @Test
    void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_robot_manage_two_lockers_and_both_not_full(){
        Locker firstlocker = new Locker(20);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstlocker,new Locker(15)));
        Bag myBag = new Bag();
        Ticket ticket = robot.store(myBag);

        assertNotNull(ticket);
        Bag bag = firstlocker.pickUp(ticket);
        assertSame(myBag,bag);
    }
}
