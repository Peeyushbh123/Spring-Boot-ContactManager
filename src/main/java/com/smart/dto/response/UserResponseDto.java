package com.smart.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.entities.User;

public class UserResponseDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email_id")
    private String email;

    @JsonProperty("role")
    private String role;

    @JsonProperty("is_enabled")
    private boolean enabled;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("about")
    private String about;

    public UserResponseDto() {
    }

    public UserResponseDto(int id, String name, String email, String role, boolean enabled, String imageUrl, String about) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
        this.imageUrl = imageUrl;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void convertToUserResponse(User user){
        setEmail(user.getEmail());
        setId(user.getId());
        setAbout(user.getAbout());
        setEnabled(user.isEnabled());
        setImageUrl(user.getImageUrl());
        setName(user.getName());
        setRole(user.getRole());
    }
}
