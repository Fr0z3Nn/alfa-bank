package ru.project.alfastonks.exception.handler;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.project.alfastonks.exception.BadBaseException;
import ru.project.alfastonks.exception.response.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
        super();
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Response> FeignException(Exception e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(BadBaseException.class)
    public ResponseEntity<Response> BaseException(Exception e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> otherException(Exception e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
