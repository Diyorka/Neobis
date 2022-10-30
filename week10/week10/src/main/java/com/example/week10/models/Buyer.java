package com.example.week10.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Name can not be empty!")
    @Column(name = "firstName")
    private String firstName;

    @NotEmpty(message = "Surname can not be empty!")
    @Column(name = "lastName")
    private String lastName;

    @NotEmpty(message = "Phone number can not be empty!")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotEmpty(message = "Username can not be empty")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Password can not be empty!")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}
