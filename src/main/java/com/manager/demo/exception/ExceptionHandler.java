/**
 * The ExceptionHandler class provides a custom exception handling mechanism for MethodArgumentNotValidException.
 * When a MethodArgumentNotValidException is thrown, it is caught by this class and transformed into an ErrorDetail object.
 * This object contains the date, a message describing the validation error, and the default error message associated with the exception.
 * This class returns a ResponseEntity object that encapsulates the ErrorDetail object and an HTTP status code.
 * If the exception is a MethodArgumentNotValidException, it returns a 400 Bad Request status code.
 */

package com.manager.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * This method provides a custom exception handling mechanism for MethodArgumentNotValidException.
 * @param exception The MethodArgumentNotValidException that was thrown.
 * @return A ResponseEntity object that encapsulates an ErrorDetail object and an HTTP status code.
 * If the exception is a MethodArgumentNotValidException, it returns a 400 Bad Request status code.
 */
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> exceptionHandling(MethodArgumentNotValidException exception){
        ErrorDetail errorDetail = new ErrorDetail(new Date(), "Validation error", exception.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }
}
