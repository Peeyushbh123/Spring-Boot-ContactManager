package com.smart.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRequestDto {

    @JsonProperty("name")
    @Size(min=2)
    private String name;
    @JsonProperty("password")
    @Size(min=2,max = 20)
    private String password;
    @JsonProperty("email_id")
    @Email
    private String email;
    @JsonProperty("about")
    @Size(max = 10000)
    private String about;

    public UserRequestDto() {

    }

    public UserRequestDto(String name, String passWord, String email, String about) {
        this.name = name;
        this.password = passWord;
        this.email = email;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
