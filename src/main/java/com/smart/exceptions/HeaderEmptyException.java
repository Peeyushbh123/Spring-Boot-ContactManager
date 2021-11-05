package com.smart.exceptions;

public class HeaderEmptyException extends Exception{
    String errorMessage;

    public HeaderEmptyException() {

    }

    public HeaderEmptyException(String errorMessage) {
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
