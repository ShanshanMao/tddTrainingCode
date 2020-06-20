package com.locker;
/**
 * created by ssmao on 20200613
 */

import com.locker.exception.InvalidTicketException;
import com.locker.exception.NoRoomException;
import org.junit.Assert;
import org.junit.Test;


public class LockerTest {

    @Test
    public void should_return_a_ticket_when_storing_a_bag_given_a_locker_with_one_available_cell() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Ticket ticket = locker.store(bag);

        Assert.assertEquals(ticket.getClass(), Ticket.class);
    }

    @Test(expected = NoRoomException.class)
    public void should_throw_noRoomException_when_storing_a_bag_given_a_locker_with_no_available_cell() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        locker.store(bag);

        Bag anotherBag = new Bag();
        locker.store(anotherBag);
    }


    @Test
    public void should_return_a_bag_when_pick_up_with_the_right_ticket() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.store(bag);

        Bag returnedBag = locker.pickUp(ticket);

        Assert.assertEquals(bag, returnedBag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_throw_invalidTicketException_when_pick_up_with_the_wrong_ticket() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        locker.store(bag);

        Ticket wrongTicket = new Ticket();
        locker.pickUp(wrongTicket);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_throw_invalidTicketException_when_pick_up_with_a_ticket_has_picked_up() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.store(bag);
        locker.pickUp(ticket);

        locker.pickUp(ticket);
    }
}
