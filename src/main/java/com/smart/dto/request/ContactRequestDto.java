package com.smart.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContactRequestDto {

    @NotNull
    @Size(min = 4,max = 25)
    @JsonProperty("name")
    private String name;

    @NotNull
    @Size(min = 4,max = 25)
    @JsonProperty("second_name")
    private String secondname;

    @NotNull
    @JsonProperty("work")
    private String work;

    @Column(unique=true)
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("image")
    private String image;

    @Column(length=50000)
    @JsonProperty("description")
    private String description;

}
