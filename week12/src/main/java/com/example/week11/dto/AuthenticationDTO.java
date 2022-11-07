package com.example.week11.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AuthenticationDTO {
    @NotEmpty(message = "Username can not be empty")
    private String username;
    @NotEmpty(message = "Password can not be empty!")
    private String password;
}
