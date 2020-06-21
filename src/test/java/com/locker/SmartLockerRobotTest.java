package com.locker;

import com.locker.exception.InvalidTicketException;
import com.locker.exception.NoRoomException;
import org.junit.Assert;
import org.junit.Test;
import static java.util.Arrays.asList;


public class SmartLockerRobotTest {
    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_capacity_is_the_same() {
        Locker firstLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstLocker,new Locker(2)));
        Bag myBag = new Bag();

        Ticket ticket = smartLockerRobot.store(myBag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,firstLocker.pickUp(ticket));
    }

    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_first_locker_capacity_more() {
        Locker firstLocker = new Locker(5);
        Locker secondLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstLocker,secondLocker));
        Bag myBag = new Bag();

        Ticket ticket = smartLockerRobot.store(myBag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,firstLocker.pickUp(ticket));
    }

    @Test
    public void should_store_in_2nd_locker_and_return_ticket_when_store_bag_given_smart_robot_manage_two_lockers_and_2nd_locker_capacity_more() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(5);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstLocker,secondLocker));
        Bag myBag = new Bag();

        Ticket ticket = smartLockerRobot.store(myBag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,secondLocker.pickUp(ticket));
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
        Assert.assertSame(myBag,bag);
    }

    @Test
    public void should_return_a_bag_store_in_primary_robot_success_when_pick_up_bag_a_given_a_valid_ticket_to_smart_robot() {
        Bag myBag = new Bag();
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstLocker,secondLocker));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(firstLocker,secondLocker));
        Ticket ticket = primaryLockerRobot.store(myBag);

        Bag bag = smartLockerRobot.pickUp(ticket);
        Assert.assertSame(myBag,bag);
    }

    @Test
    public void should_return_a_bag_store_in_smart_robot_success_when_pick_up_bag_a_given_a_valid_ticket_to_primary_robot() {
        Bag myBag = new Bag();
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(firstLocker,secondLocker));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(firstLocker,secondLocker));
        Ticket ticket = smartLockerRobot.store(myBag);

        Bag bag = primaryLockerRobot.pickUp(ticket);
        Assert.assertSame(myBag,bag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_a_bag_fail_when_pick_up_given_a_invalid_ticket_to_smart_robot() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(new Locker(1),new Locker(1)));

        smartLockerRobot.pickUp(new Ticket());
    }

    @Test
    public void should_return_a_ticket_when_store_3_bags_with_two_locker_with_2_capacity_in_smartLockerRobot(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(asList(new Locker(2), new Locker(2)));
        smartLockerRobot.store(new Bag());
        smartLockerRobot.store(new Bag());
        smartLockerRobot.store(new Bag());
        Ticket ticket = smartLockerRobot.store(new Bag());

        Assert.assertSame(Ticket.class,ticket.getClass());
    }

}
