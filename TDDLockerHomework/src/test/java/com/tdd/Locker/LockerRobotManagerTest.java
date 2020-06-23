package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;
import org.junit.Test;

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
        assertSame(myBag,firstlocker.pickUp(ticket));
    }

    @Test
    public void should_store_in_2nd_locker_and_return_ticket_when_store_bag_given_manager_robot_manage_two_lockers_and_1st_is_full_2nd_not_full(){
        Locker secondlocker = new Locker(5);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(new Locker(1),secondlocker),asList());
        lockerRobotManager.store(new Bag());

        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag,secondlocker.pickUp(ticket));
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
}
