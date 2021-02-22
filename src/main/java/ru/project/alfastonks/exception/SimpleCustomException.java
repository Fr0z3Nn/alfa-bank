package ru.project.alfastonks.exception;

public class SimpleCustomException extends RuntimeException {
    public SimpleCustomException(String message) {
        super(message);
    }

    public SimpleCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public SimpleCustomException(Throwable cause) {
        super(cause);
    }

    public SimpleCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
