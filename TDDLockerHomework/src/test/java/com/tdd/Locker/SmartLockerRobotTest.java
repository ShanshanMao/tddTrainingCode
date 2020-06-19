package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;
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

    @Test(expected = NoRoomException.class)
    public void should_store_in_locker_is_fail_when_store_bag_given_smart_robot_manage_two_lockers_and_both_full() {
        SmartLockerRobot robot = new SmartLockerRobot(asList(new Locker(1), new Locker(1)));
        robot.store(new Bag());
        robot.store(new Bag());

        robot.store(new Bag());
    }

    @Test
    public void should_return_a_bag_success_when_pick_up_bag_given_a_valid_ticket_to_smart_robot() {
        Bag myBag = new Bag();
        SmartLockerRobot robot = new SmartLockerRobot(asList(new Locker(1),new Locker(1)));
        Ticket ticket = robot.store(myBag);

        Bag bag = robot.pickUp(ticket);
        assertSame(myBag,bag);
    }

}
