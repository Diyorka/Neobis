package com.example.week9.services;

import com.example.week9.models.Buyer;
import com.example.week9.models.Laptop;
import com.example.week9.models.Order;
import com.example.week9.repositories.BuyersRepository;
import com.example.week9.repositories.LaptopsRepository;
import com.example.week9.repositories.OrdersRepository;
import com.example.week9.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final LaptopsRepository laptopsRepository;
    private final BuyersRepository buyersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, LaptopsRepository laptopsRepository, BuyersRepository buyersRepository) {
        this.ordersRepository = ordersRepository;
        this.laptopsRepository = laptopsRepository;
        this.buyersRepository = buyersRepository;
    }

    public List<Order> findAll(){
        return ordersRepository.findAll();
    }

    public Order findById(int id){
        Optional<Order> order = ordersRepository.findById(id);
        return order.orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void addOrder(Order order){
        order.setOrderDate(String.valueOf(LocalDateTime.now()));
        ordersRepository.save(order);
    }


    @Transactional
    public void updateOrder(int id, Order newOrder){
        Optional<Order> order = ordersRepository.findById(id);
        if(order.isPresent()){
            newOrder.setId(order.get().getId());
            newOrder.setOrderDate(String.valueOf(LocalDateTime.now()));
            ordersRepository.save(newOrder);
        }else{
            throw new NotFoundException();
        }

    }

    @Transactional
    public void deleteById(int id){
        if(ordersRepository.findById(id).isPresent()) {
            ordersRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

}
