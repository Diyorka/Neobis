package com.example.part2.services;

import com.example.part2.models.Buyer;
import com.example.part2.models.Laptop;
import com.example.part2.models.Order;
import com.example.part2.repositories.BuyersRepository;
import com.example.part2.repositories.LaptopsRepository;
import com.example.part2.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<List<Order>> findAll(){
        return new ResponseEntity<>(ordersRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findById(int id){
        Optional<Order> order = ordersRepository.findById(id);
        if(order.isEmpty())
            return new ResponseEntity<>("Order wasn't found", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }

    public ResponseEntity<String> addOrder(int laptopId, int buyerId, String orderDate){
        Optional<Laptop> laptop = laptopsRepository.findById(laptopId);
        Optional<Buyer> buyer = buyersRepository.findById(buyerId);
        if(laptop.isEmpty() || buyer.isEmpty())
            return new ResponseEntity<>("Laptop or Buyer wasn't found!", HttpStatus.NOT_FOUND);

        Order order = new Order(laptop.get(), buyer.get(), orderDate);
        ordersRepository.save(order);
        return new ResponseEntity<>("Order was successfully saved!", HttpStatus.OK);
        }


    public ResponseEntity<String> updateOrder(int id, int laptopId, int buyerId, String orderDate){
        Optional<Laptop> laptop = laptopsRepository.findById(laptopId);
        Optional<Buyer> buyer = buyersRepository.findById(buyerId);
        if(laptop.isEmpty() || buyer.isEmpty())
            return new ResponseEntity<>("Laptop or Buyer wasn't found!", HttpStatus.NOT_FOUND);

        Order order = new Order(laptop.get(), buyer.get(), orderDate);
        order.setId(id);
        ordersRepository.save(order);
        return new ResponseEntity<>("Order was successfully saved!", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteOrder(int id){
        Optional<Order> order = ordersRepository.findById(id);
        if(order.isEmpty())
            return new ResponseEntity<>("Order wasn't found!", HttpStatus.NOT_FOUND);

        try{
            ordersRepository.deleteById(id);
            return new ResponseEntity<>("Order was deleted!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Order wasn't deleted!", HttpStatus.BAD_REQUEST);
        }
    }

}
