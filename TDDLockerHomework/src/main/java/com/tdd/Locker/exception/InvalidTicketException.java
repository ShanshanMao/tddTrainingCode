package com.tdd.Locker.exception;

public class InvalidTicketException extends RuntimeException {
    public InvalidTicketException(String message) {
        super(message);
    }

    public InvalidTicketException() {
        super();

    }
}
