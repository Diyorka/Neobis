package com.example.week10.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BuyerDTO {
    @NotEmpty(message = "Name can not be empty!")
    private String firstName;

    @NotEmpty(message = "Surname can not be empty!")
    private String lastName;

    @NotEmpty(message = "Phone number can not be empty!")
    private String phoneNumber;

    @NotEmpty(message = "Username can not be empty")
    private String username;

    @NotEmpty(message = "Password can not be empty!")
    private String password;
}
