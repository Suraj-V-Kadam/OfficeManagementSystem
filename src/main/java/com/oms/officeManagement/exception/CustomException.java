package com.oms.officeManagement.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
public class CustomException extends RuntimeException{
    private String errorMessage;
    private HttpStatus status;
    private int statusCode;
    private String duration;

    public CustomException() {
    }

    public CustomException(String errorMessage, HttpStatus status, String duration) {
        this.errorMessage = errorMessage;
        this.status = status;
        this.statusCode = status.value();
        this.duration = duration;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }



    public String getDuration() {
        return duration;
    }


}
