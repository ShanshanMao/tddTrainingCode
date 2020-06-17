package com.tdd.Locker;

import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    void should_return_a_bag_success_when_pick_up_bag_given_a_valid_ticket_to_robot() throws Throwable {
        Bag myBag = new Bag();
        Locker firstlocker = new Locker(20);
        Locker secondlocker = new Locker(20);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstlocker,secondlocker));

        Ticket ticket = robot.store(myBag);

        Bag returnedBag = firstlocker.pickUp(ticket);
        assertSame(myBag,returnedBag);
    }

    @Test
    void should_return_a_bag_fail_when_pick_up_given_a_invalid_ticket_to_robot() {
        Ticket ticket = new Ticket();
        Locker firstlocker = new Locker(1);
        Locker secondlocker = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstlocker,secondlocker));

        assertThatThrownBy(()->robot.pickUp(ticket))
                .isInstanceOf(InvalidTicketException.class);
    }

}
