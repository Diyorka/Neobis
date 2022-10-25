package com.example.week9.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "manufacturer")
    @NotEmpty(message = "Manufacturer can not be empty!")
    private String manufacturer;

    @NotEmpty(message = "Model can not be empty!")
    @Column(name = "model")
    private String model;

    @Min(value = 0, message = "Price should be greater than 0")
    @Column(name = "price")
    private int price;
}
