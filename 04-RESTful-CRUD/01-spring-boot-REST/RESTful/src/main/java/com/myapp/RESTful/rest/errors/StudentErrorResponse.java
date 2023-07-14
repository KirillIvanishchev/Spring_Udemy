package com.myapp.RESTful.rest.errors;

import java.lang.invoke.StringConcatException;
import java.util.Date;

//ENTITY for HANDLING ERRORS in form of a class
//basically just the custom Error class with custom fields. No need to use in some cases. Made just to clarify the exception.
public class StudentErrorResponse {
    private int status;
    private String message;
    private String timestamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, String timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}