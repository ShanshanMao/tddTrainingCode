package com.tdd.Locker;
/**
 * created by ssmao on 20200613
 */

import com.tdd.Locker.exception.InvalidTicketException;
import com.tdd.Locker.exception.NoRoomException;
import lombok.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.*;



public class LockerTest {

    @Test
    public void should_return_a_ticket_when_storing_a_bag_given_a_locker_with_one_available_cell() {
        var locker = new Locker(1);
        var bag = new Bag();

        var ticket = locker.store(bag);

        assertThat(ticket).isInstanceOf(Ticket.class);
    }

    @Test
    public void should_throw_noRoomException_when_storing_a_bag_given_a_locker_with_no_available_cell() {
        var locker = new Locker(1);
        var bag = new Bag();

        locker.store(bag);

        var anotherBag = new Bag();
        assertThatThrownBy(() -> locker.store(anotherBag)).isInstanceOf(NoRoomException.class);
    }


    @Test
    public void should_return_a_bag_when_pick_up_with_the_right_ticket() {
        var locker = new Locker(1);
        var bag = new Bag();
        var ticket = locker.store(bag);

        var returnedBag = locker.pickUp(ticket);

        assertThat(returnedBag).isEqualTo(bag);
    }

    @Test
    public void should_throw_invalidTicketException_when_pick_up_with_the_wrong_ticket() {
        var locker = new Locker(1);
        var bag = new Bag();
        locker.store(bag);

        var wrongTicket = new Ticket();

        assertThatThrownBy(()-> locker.pickUp(wrongTicket)).isInstanceOf(InvalidTicketException.class);
    }

    @Test
    public void should_throw_invalidTicketException_when_pick_up_with_a_ticket_has_picked_up() {
        var locker = new Locker(1);
        var bag = new Bag();
        var ticket = locker.store(bag);
        locker.pickUp(ticket);

        assertThatThrownBy(()-> locker.pickUp(ticket)).isInstanceOf(InvalidTicketException.class);
    }
}
