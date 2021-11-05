package com.smart.exceptions;

public class PasswordNotMatchException extends Exception{
    String errorMessage;

    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String errorMessage) {
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
