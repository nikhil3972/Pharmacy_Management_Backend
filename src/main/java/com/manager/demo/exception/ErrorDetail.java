package com.manager.demo.exception;

import java.util.Date;

/**
 * The ErrorDetail class represents the details of an error that occurred in the application.
 * It contains information about the timestamp when the error occurred, the error message and its details.
 */
public class ErrorDetail {

    private Date timestamp;
    private String message;
    private String details;


    /**
     * Constructs an ErrorDetail object with the given timestamp, message, and details.
     * @param timestamp the timestamp when the error occurred.
     * @param message the message describing the error.
     * @param details the details of the error, providing additional information.
     */
    public ErrorDetail(Date timestamp, String message, String details){
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
