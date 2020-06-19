package com.tdd.Locker;

import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;
import org.junit.Test;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartLockerRobotTest {
    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_capacity_is_the_same() {
        Locker firstlocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstlocker,new Locker(2)));
        Bag myBag = new Bag();

        Ticket ticket = smartLockerRobot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstlocker.pickUp(ticket));
    }

    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_first_locker_capacity_more() {
        Locker firstlocker = new Locker(5);
        Locker secondlocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstlocker,secondlocker));
        Bag myBag = new Bag();

        Ticket ticket = smartLockerRobot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstlocker.pickUp(ticket));
    }

    @Test
    public void should_store_in_2nd_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_2nd_locker_capacity_more() {
        Locker firstlocker = new Locker(2);
        Locker secondlocker = new Locker(5);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstlocker,secondlocker));
        Bag myBag = new Bag();

        Ticket ticket = smartLockerRobot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,secondlocker.pickUp(ticket));
    }

    @Test(expected = NoRoomException.class)
    public void should_store_in_locker_is_fail_when_store_bag_given_smart_robot_manage_two_lockers_and_both_full() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(new Locker(1), new Locker(1)));
        smartLockerRobot.store(new Bag());
        smartLockerRobot.store(new Bag());

        smartLockerRobot.store(new Bag());
    }

    @Test
    public void should_return_a_bag_success_when_pick_up_bag_given_a_valid_ticket_to_smart_robot() {
        Bag myBag = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(new Locker(1),new Locker(1)));
        Ticket ticket = smartLockerRobot.store(myBag);

        Bag bag = smartLockerRobot.pickUp(ticket);
        assertSame(myBag,bag);
    }

    @Test
    public void should_return_a_bag_store_in_primary_robot_success_when_pick_up_bag_a_given_a_valid_ticket_to_smart_robot() {
        Bag myBag = new Bag();
        Locker firstlocker = new Locker(1);
        Locker secondlocker = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstlocker,secondlocker));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(firstlocker,secondlocker));
        Ticket ticket = primaryLockerRobot.store(myBag);

        Bag bag = smartLockerRobot.pickUp(ticket);
        assertSame(myBag,bag);
    }

    @Test
    public void should_return_a_bag_store_in_smart_robot_success_when_pick_up_bag_a_given_a_valid_ticket_to_primary_robot() {
        Bag myBag = new Bag();
        Locker firstlocker = new Locker(1);
        Locker secondlocker = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstlocker,secondlocker));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(firstlocker,secondlocker));
        Ticket ticket = smartLockerRobot.store(myBag);

        Bag bag = primaryLockerRobot.pickUp(ticket);
        assertSame(myBag,bag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_a_bag_fail_when_pick_up_given_a_invalid_ticket_to_smart_robot() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(new Locker(1),new Locker(1)));

        smartLockerRobot.pickUp(new Ticket());
    }

}
