package com.epam.enote.exception;

public class NoSuchNotebookException extends RuntimeException {
    public NoSuchNotebookException(String message) {
        super(message);
    }
}
