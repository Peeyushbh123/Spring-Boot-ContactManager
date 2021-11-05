package com.smart.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.entities.Contact;
import com.smart.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactResponseDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("second_name")
    private String secondname;

    @JsonProperty("work")
    private String work;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("image")
    private String image;

    @JsonProperty("description")
    private String description;

    public void convertToConResponse(Contact contact){
        setEmail(contact.getEmail());
        setId(contact.getcId());
        setDescription(contact.getDescription());
        setImage(contact.getImage());
        setPhone(contact.getPhone());
        setName(contact.getName());
        setWork(contact.getWork());
        setSecondname(contact.getSecondname());
    }

}
