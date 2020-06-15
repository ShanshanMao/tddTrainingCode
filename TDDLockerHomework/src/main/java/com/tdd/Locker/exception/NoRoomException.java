package com.tdd.Locker.exception;

public class NoRoomException extends RuntimeException {
    public NoRoomException(String message) {
        super(message);
    }

    public NoRoomException() {
        super();

    }
}
