package com.tdd.Locker;

import com.tdd.Locker.exception.NoRoomException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrimaryLockerRobotTest {
    @Test
    void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_robot_manage_two_lockers_and_both_not_full() throws Throwable {
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
    void should_store_in_2nd_locker_and_return_ticket_when_store_bag_given_robot_manage_1st_is_full_and_2nd_locker_is_not_full() throws Throwable {
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

    @Test
    void should_store_in_locker_is_fail_when_store_bag_given_robot_manage_two_lockers_and_both_full(){
        Bag myBag = new Bag();
        Locker firstlocker = new Locker(1);
        firstlocker.store(new Bag());
        Locker secondlocker = new Locker(1);
        secondlocker.store(new Bag());
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstlocker,secondlocker));

        assertThatThrownBy(() ->robot.store(myBag)).isInstanceOf(NoRoomException.class);
    }

}
