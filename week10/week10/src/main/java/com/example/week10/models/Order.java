package com.example.week10.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "laptopId", referencedColumnName = "id")
    private Laptop laptop;

    @ManyToOne
    @JoinColumn(name = "buyerId", referencedColumnName = "id")
    private Buyer buyer;

    @Column(name = "orderDate")
    private String orderDate;

    public Order(Laptop laptop, Buyer buyer, String orderDate) {
        this.laptop = laptop;
        this.buyer = buyer;
        this.orderDate = orderDate;
    }

}
