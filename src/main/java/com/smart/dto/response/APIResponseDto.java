package com.smart.dto.response;

public class APIResponseDto<T> {
    private T data;
    private String message;

    public APIResponseDto() {

    }

    public APIResponseDto(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
