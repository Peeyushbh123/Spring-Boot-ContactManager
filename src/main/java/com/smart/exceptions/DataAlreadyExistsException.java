package com.smart.exceptions;

public class DataAlreadyExistsException extends Exception{
    String errorMessage;

    public DataAlreadyExistsException() {

    }

    public DataAlreadyExistsException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
