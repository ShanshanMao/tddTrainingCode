package com.tdd.Locker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrimaryLockerRobotTest {
    @Test
    void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_robot_manage_two_lockers_and_both_not_full(){
        Locker firstlocker = new Locker(20);
        Locker secondlocker = new Locker(20);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstlocker,secondlocker));
        Bag myBag = new Bag();

        Ticket ticket = robot.store(myBag);

        assertNotNull(ticket);
        Bag bag = firstlocker.pickUp(ticket);
        assertSame(myBag,bag);
    }

    @Test
    void should_shore_in_2nd_locker_and_return_ticket_when_store_bag_given_robot_manage_1st_is_full_and_2nd_locker_is_not_full(){
        Locker firstlocker = new Locker(1);
        Locker secondlocker = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstlocker,secondlocker));
        Bag myBag = new Bag();
        firstlocker.store(new Bag());

        Ticket ticket =robot.store(myBag);

        assertNotNull(ticket);
        Bag bag = secondlocker.pickUp(ticket);
        assertSame(myBag,bag);
    }

}
