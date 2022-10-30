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
@Table(name = "Worker")
public class Worker {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    @NotEmpty(message = "Name can not be empty!")
    private String firstName;

    @Column(name = "lastName")
    @NotEmpty(message = "Surname can not be empty!")
    private String lastName;

    @Column(name = "phoneNumber")
    @NotEmpty(message = "Phone number can not be empty!")
    private String phoneNumber;

    @Column(name = "position")
    @NotEmpty(message = "Position can not be empty!")
    private String position;

    @Column(name = "username")
    @NotEmpty(message = "Username can not be empty!")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "Password can not be empty!")
    private String password;

    @Column(name = "role")
    private String role;
}
