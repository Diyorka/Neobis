package com.example.courseproject3.dto;

import com.example.courseproject3.models.Buyer;
import com.example.courseproject3.models.Laptop;
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
