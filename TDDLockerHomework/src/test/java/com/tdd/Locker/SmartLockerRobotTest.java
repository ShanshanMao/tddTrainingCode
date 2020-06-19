package com.tdd.Locker;

import org.junit.Test;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartLockerRobotTest {
    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_capacity_is_the_same() {
        Locker firstlocker = new Locker(2);
        SmartLockerRobot robot = new SmartLockerRobot(asList(firstlocker,new Locker(2)));
        Bag myBag = new Bag();

        Ticket ticket = robot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstlocker.pickUp(ticket));
    }

    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_first_locker_capacity_more() {
        Locker firstlocker = new Locker(5);
        Locker secondlocker = new Locker(2);
        SmartLockerRobot robot = new SmartLockerRobot(asList(firstlocker,secondlocker));
        Bag myBag = new Bag();

        Ticket ticket = robot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstlocker.pickUp(ticket));
    }

    @Test
    public void should_store_in_2nd_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_2nd_locker_capacity_more() {
        Locker firstlocker = new Locker(2);
        Locker secondlocker = new Locker(5);
        SmartLockerRobot robot = new SmartLockerRobot(asList(firstlocker,secondlocker));
        Bag myBag = new Bag();

        Ticket ticket = robot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,secondlocker.pickUp(ticket));
    }
}
