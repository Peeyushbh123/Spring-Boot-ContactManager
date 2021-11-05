package com.smart.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginRequestDto {

    @JsonProperty("email_id")
    @Email
    private String email;

    @JsonProperty("password")
    @NotEmpty
    private String password;

    public LoginRequestDto() {

    }

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
