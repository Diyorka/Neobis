package com.example.part2.controllers;

import com.example.part2.models.Order;
import com.example.part2.services.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService orderService;


    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable int id){
        return orderService.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addOrder(@RequestParam int laptopId,
                                           @RequestParam int buyerId,
                                           @RequestParam String orderDate){
        return orderService.addOrder(laptopId, buyerId, orderDate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable int id,
                                              @RequestParam int laptopId,
                                              @RequestParam int buyerId,
                                              @RequestParam String orderDate) {
        return orderService.updateOrder(id, laptopId, buyerId, orderDate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id){
        return orderService.deleteOrder(id);
    }
}
