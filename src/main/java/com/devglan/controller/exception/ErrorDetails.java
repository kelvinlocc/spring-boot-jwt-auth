package com.devglan.controller.exception;

import java.util.Date;

/**
 * Created by ccloa on 21/6/2018.
 */
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
