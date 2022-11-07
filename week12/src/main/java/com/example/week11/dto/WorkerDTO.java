package com.example.week11.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {
    @NotEmpty(message = "Name can not be empty!")
    private String firstName;

    @NotEmpty(message = "Surname can not be empty!")
    private String lastName;

    @NotEmpty(message = "Phone number can not be empty!")
    private String phoneNumber;

    @NotEmpty(message = "Position can not be empty!")
    private String position;

    @NotEmpty(message = "Username can not be empty!")
    private String username;

    @NotEmpty(message = "Password can not be empty!")
    private String password;
}
