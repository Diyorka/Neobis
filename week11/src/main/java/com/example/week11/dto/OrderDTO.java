package com.example.week11.dto;

import com.example.week11.models.Buyer;
import com.example.week11.models.Laptop;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Laptop laptop;
    private Buyer buyer;
    private String orderDate;

    public OrderDTO(Laptop laptop, Buyer buyer) {
        this.laptop = laptop;
        this.buyer = buyer;
    }
}
