package com.locker;

import com.locker.exception.NoRoomException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class LockerRobotManagerTest {
    @Test
    public void should_return_a_ticket_and_store_in_1st_locker_when_LockerRobotManager_have_2_locker_with_available_capacity_and_no_robot() {
        Locker firstLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, new Locker(1)),Collections.emptyList());
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag, firstLocker.pickUp(ticket));
    }

    @Test
    public void should_return_a_ticket_and_store_in_2nd_locker_when_LockerRobotManager_have_1_full_locker_1_available_capacity_locker_and_no_robot(){
        Locker firstLocker = new Locker(1);
        firstLocker.store(new Bag());
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker),Collections.emptyList());
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,secondLocker.pickUp(ticket));
    }

    @Test(expected = NoRoomException.class)
    public void should_return_a_NoRoomException_when_LockerRobotManager_have_2_full_lockers_and_no_robot(){
        Locker firstLocker = new Locker(1);
        firstLocker.store(new Bag());
        Locker secondLocker = new Locker(1);
        secondLocker.store(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker),Collections.emptyList());
        lockerRobotManager.store(new Bag());
    }

    @Test
    public void should_return_a_ticket_and_store_in_1st_robot_when_LockerRobotManager_have_2_robot_with_available_capacity_but_no_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1),new Locker(1)));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1),new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot, smartLockerRobot));
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,primaryLockerRobot.pickUp(ticket));
    }

    @Test
    public void should_return_a_ticket_and_store_in_2nd_robot_when_LockerRobotManager_have_1st_full_robot_and_2nd_robot_with_available_capacity_but_no_locker(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1),new Locker(1)));
        primaryLockerRobot.store(new Bag());
        primaryLockerRobot.store(new Bag());
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1),new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot, smartLockerRobot));
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,smartLockerRobot.pickUp(ticket));
    }

    @Test(expected = NoRoomException.class)
    public void should_return_a_NoRoomException_when_LockerRobotManager_have_2_full_robot_and_no_locker(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1),new Locker(1)));
        primaryLockerRobot.store(new Bag());
        primaryLockerRobot.store(new Bag());
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(1),new Locker(1)));
        smartLockerRobot.store(new Bag());
        smartLockerRobot.store(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.emptyList(), Arrays.asList(primaryLockerRobot, smartLockerRobot));
        Bag myBag = new Bag();
        lockerRobotManager.store(myBag);
    }

    @Test
    public void should_return_a_ticket_when_LockerRobotManager_have_1_robot_and_1_locker_both_have_available_capacity(){
        PrimaryLockerRobot lockerRobot = new PrimaryLockerRobot(Arrays.asList(new Locker(1), new Locker(1)));
        Locker locker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(locker), Collections.singletonList(lockerRobot));
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,lockerRobot.pickUp(ticket));
    }

    @Test
    public void should_return_a_ticket_and_store_in_locker_when_LockerRobotManager_have_1_full_robot_and_1_locker_have_available_capacity(){
        PrimaryLockerRobot lockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1)));
        lockerRobot.store(new Bag());
        Locker locker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(locker), Collections.singletonList(lockerRobot));
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertNotNull(ticket);
        Assert.assertSame(myBag,locker.pickUp(ticket));
    }

    @Test(expected = NoRoomException.class)
    public void should_return_NoRoomException_when_LockerRobotManager_have_1_full_robot_and_1_full_locker(){
        PrimaryLockerRobot lockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1)));
        lockerRobot.store(new Bag());
        Locker locker = new Locker(1);
        locker.store(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(locker), Collections.singletonList(lockerRobot));
        Bag myBag = new Bag();
        lockerRobotManager.store(myBag);
    }

    @Test
    public void should_return_bag_when_pickUp_bag_with_valid_ticket_and_LockerRobotManager_have_2_lockers_but_no_robot(){
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker), Collections.emptyList());
        Bag myBag = new Bag();
        Ticket ticket = lockerRobotManager.store(myBag);
        Assert.assertSame(myBag, lockerRobotManager.pickUp(ticket));
    }
}
