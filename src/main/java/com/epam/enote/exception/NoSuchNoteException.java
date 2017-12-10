package com.epam.enote.exception;

public class NoSuchNoteException extends RuntimeException {
    public NoSuchNoteException(String message) {
        super(message);
    }
}
