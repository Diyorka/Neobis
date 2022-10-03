package com.example.part1.models;

import javax.persistence.*;

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

    public Order(){}

    public Order(Laptop laptop, Buyer buyer, String orderDate) {
        this.laptop = laptop;
        this.buyer = buyer;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
