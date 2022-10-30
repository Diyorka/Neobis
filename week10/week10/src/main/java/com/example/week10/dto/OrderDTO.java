package com.example.week10.dto;

import com.example.week10.models.Buyer;
import com.example.week10.models.Laptop;
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
