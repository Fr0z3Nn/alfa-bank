package ru.project.alfastonks.exception;

public class BadBaseException extends RuntimeException {
    public BadBaseException(String message) {
        super(message);
    }

    public BadBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadBaseException(Throwable cause) {
        super(cause);
    }

    public BadBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
