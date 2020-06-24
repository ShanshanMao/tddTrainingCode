package com.tdd.Locker;

import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;
import org.junit.Test;

import static org.junit.Assert.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class LockerRobotManagerTest {

    private PrimaryLockerRobot firstRobot;
    private SmartLockerRobot secondRobot;


    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_manager_robot_manage_two_lockers_and_both_not_full(){
        Locker firstlocker = new Locker(2);
        Locker secondlocker = new Locker(2);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstlocker,secondlocker),asList());
        Bag myBag = new Bag();

        Ticket ticket = lockerRobotManager.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstlocker.find(ticket));
    }

    @Test
    public void should_store_in_2nd_locker_and_return_ticket_when_store_bag_given_manager_robot_manage_two_lockers_and_1st_is_full_2nd_not_full(){
        Locker secondlocker = new Locker(5);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(new Locker(1),secondlocker),asList());
        lockerRobotManager.store(new Bag());

        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,secondlocker.find(ticket));
    }

    @Test(expected = NoRoomException.class)
    public void should_store_in_locker_is_fail_when_store_bag_given_manager_robot_manage_two_lockers_and_both_full(){
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(new Locker(1),new Locker(1)),asList());
        lockerRobotManager.store(new Bag());
        lockerRobotManager.store(new Bag());

        lockerRobotManager.store(new Bag());
    }

    @Test
    public void should_store_in_1st_robot_locker_and_return_ticket_when_store_bag_given_manager_robot_manage_two_robot_and_both_not_full(){
        firstRobot = new PrimaryLockerRobot(asList(new Locker(5)));
        secondRobot = new SmartLockerRobot(asList(new Locker(5)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(),asList(firstRobot,secondRobot));
        Bag myBag = new Bag();

        Ticket ticket = lockerRobotManager.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstRobot.pickUp(ticket));
    }

    @Test
    public void should_store_in_2nd_robot_locker_and_return_ticket_when_store_bag_given_manager_robot_manage_two_robot_and_1st_robot_locker_is_full_and_2nd_robot_locker_not_full(){
        firstRobot = new PrimaryLockerRobot(asList(new Locker(1)));
        secondRobot = new SmartLockerRobot(asList(new Locker(5)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(),asList(firstRobot,secondRobot));

        lockerRobotManager.store(new Bag());
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,secondRobot.pickUp(ticket));
    }

    @Test(expected = NoRoomException.class)
    public void should_store_in_locker_is_fail_when_store_bag_given_manager_robot_manage_two_robot_and_robot_locker_both_full(){
        firstRobot = new PrimaryLockerRobot(asList(new Locker(1)));
        secondRobot = new SmartLockerRobot(asList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(),asList(firstRobot,secondRobot));
        lockerRobotManager.store(new Bag());
        lockerRobotManager.store(new Bag());

        lockerRobotManager.store(new Bag());
    }

    @Test
    public void should_store_in_1st_robot_locker_and_return_ticket_when_store_bag_given_manager_robot_manage_1_locker_and_1_robot_locker_both_not_full(){
        firstRobot = new PrimaryLockerRobot(asList(new Locker(2)));
        Locker firstlocker = new Locker(2);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstlocker),asList(firstRobot));

        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,firstRobot.pickUp(ticket));
    }

    @Test
    public void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_manager_robot_manage_1_locker_has_not_full_and_1_robot_locker_is_full(){
        firstRobot = new PrimaryLockerRobot(asList(new Locker(1)));
        Locker firstlocker = new Locker(2);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstlocker),asList(firstRobot));
        lockerRobotManager.store(new Bag());

        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);

        assertNotNull(ticket);
        assertSame(firstlocker.find(ticket),myBag);
        assertTrue(lockerRobotManager.isValid(ticket));
    }

    @Test(expected = NoRoomException.class)
    public void should_store_in_locker_is_fail_when_store_bag_given_manager_robot_manage_1_robot_locker_and_1__locker_both_full(){
        firstRobot = new PrimaryLockerRobot(asList(new Locker(1)));
        Locker firstlocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstlocker),asList(firstRobot));
        lockerRobotManager.store(new Bag());
        lockerRobotManager.store(new Bag());

        lockerRobotManager.store(new Bag());
    }

    @Test
    public void should_return_a_bag_success_when_pick_up_bag_given_a_valid_ticket_to_robot_manager_and_manage_2_lockers(){
        Locker firstlocker = new Locker(1);
        Locker secondlocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstlocker,secondlocker),asList());
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        assertSame(firstlocker.find(ticket),myBag);

        Bag bag = lockerRobotManager.pickUp(ticket);
        assertSame(myBag,bag);
        assertNull(firstlocker.find(ticket));
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_a_bag_fail_when_pick_up_given_a_invalid_ticket_to_robot_manager() {
        Locker firstlocker = new Locker(1);
        Locker secondlocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstlocker,secondlocker),asList());

        lockerRobotManager.pickUp(new Ticket());
    }

    @Test
    public void should_return_a_bag_success_when_pick_up_bag_given_a_valid_ticket_to_robot_manager_and_manage_2_robot_lockers(){
        firstRobot = new PrimaryLockerRobot(asList(new Locker(1)));
        secondRobot = new SmartLockerRobot(asList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(),asList(firstRobot,secondRobot));

        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        assertNotNull(ticket);

        Bag bag = lockerRobotManager.pickUp(ticket);
        assertSame(myBag,bag);
        assertFalse(lockerRobotManager.isValid(ticket));
    }

    @Test(expected = InvalidTicketException.class)
    public void should_return_a_bag_fail_when_pick_up_given_a_invalid_ticket_to_robot_manager_manage_2_robot_lockers() {
        firstRobot = new PrimaryLockerRobot(asList(new Locker(1)));
        secondRobot = new SmartLockerRobot(asList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(),asList(firstRobot,secondRobot));

        lockerRobotManager.pickUp(new Ticket());
    }

    @Test
    public void should_return_a_bag_success_when_pick_up_bag_given_a_valid_ticket_to_robot_manager_and_manage_1_robot_locker_and_1_locker(){
        firstRobot = new PrimaryLockerRobot(asList(new Locker(1)));
        Locker firstlocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstlocker),asList(firstRobot));

        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        assertNotNull(ticket);

        Bag bag = lockerRobotManager.pickUp(ticket);
        assertSame(myBag,bag);
        assertFalse(lockerRobotManager.isValid(ticket));
    }

}
