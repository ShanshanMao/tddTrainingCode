package com.tdd.Locker;

import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrimaryLockerRobotTest {
    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_robot_manage_two_lockers_and_both_not_full() {
        Locker firstlocker = new Locker(20);
        Locker secondlocker = new Locker(20);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(firstlocker,secondlocker));
        Bag myBag = new Bag();

        Ticket ticket = primaryLockerRobot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstlocker.pickUp(ticket));
    }

    @Test
    public void should_store_in_2nd_locker_and_return_ticket_when_store_bag_given_robot_manage_1st_is_full_and_2nd_locker_is_not_full() {
        Locker secondlocker = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(new Locker(1),secondlocker));
        primaryLockerRobot.store(new Bag());

        Bag myBag = new Bag();
        Ticket ticket =primaryLockerRobot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,secondlocker.pickUp(ticket));
    }

    @Test(expected = NoRoomException.class)
    public void should_store_in_locker_is_fail_when_store_bag_given_robot_manage_two_lockers_and_both_full(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(new Locker(1),new Locker(1)));
        primaryLockerRobot.store(new Bag());
        primaryLockerRobot.store(new Bag());

        primaryLockerRobot.store(new Bag());
    }

    @Test
    public void should_return_a_bag_success_when_pick_up_bag_given_a_valid_ticket_to_robot() {
        Bag myBag = new Bag();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(new Locker(1),new Locker(1)));
        Ticket ticket = primaryLockerRobot.store(myBag);

        Bag bag = primaryLockerRobot.pickUp(ticket);
        assertSame(myBag,bag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_a_bag_fail_when_pick_up_given_a_invalid_ticket_to_robot() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(new Locker(1),new Locker(1)));

        primaryLockerRobot.pickUp(new Ticket());
    }

}
