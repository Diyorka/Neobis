package com.example.part2.controllers;

import com.example.part2.models.Buyer;
import com.example.part2.services.BuyersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyersController {
    private final BuyersService buyerService;

    @Autowired
    public BuyersController(BuyersService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping()
    public ResponseEntity<List<Buyer>> getAllBuyers(){
        return buyerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBuyerById(@PathVariable int id){
        return buyerService.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addBuyer(Buyer buyer) {
        return buyerService.addBuyer(buyer);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateBuyer(@PathVariable int id, Buyer newBuyer){
        return buyerService.updateBuyer(id, newBuyer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBuyer(@PathVariable int id){
        return buyerService.deleteById(id);
    }
}
