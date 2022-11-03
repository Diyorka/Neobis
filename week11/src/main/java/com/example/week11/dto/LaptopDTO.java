package com.example.week11.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDTO {
    @NotEmpty(message = "Manufacturer can not be empty!")
    private String manufacturer;

    @NotEmpty(message = "Model can not be empty!")
    private String model;

    @Min(value = 0, message = "Price should be greater than 0")
    private int price;
}
