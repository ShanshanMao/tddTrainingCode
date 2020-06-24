package com.locker;

public class ManagerTicket extends Ticket {
    private Ticket ticket;

    public ManagerTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
