package com.smart.exceptions;

public class DataNotFoundException extends Exception{
    String errorMessage;

    public DataNotFoundException() {

    }

    public DataNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
