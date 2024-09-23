package com.blitmatthew.monster_trainer.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class DefaultExceptionHandler {
    Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler({EntityNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<ApiError> exceptionHandler(EntityNotFoundException e, HttpServletRequest request){
        logger.error(e.getMessage());
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ApiError> exceptionHandler(SQLException e, HttpServletRequest request) {
        logger.error(e.getMessage());
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> exceptionHandler(Exception e, HttpServletRequest request) {
        logger.error(e.getMessage());
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
