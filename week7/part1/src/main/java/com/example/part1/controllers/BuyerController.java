package com.example.part1.controllers;

import com.example.part1.models.Buyer;
import com.example.part1.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {
    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping()
    public ResponseEntity<List<Buyer>> getAllBuyers(){
        List<Buyer> buyers = buyerService.findAll();
        return new ResponseEntity<>(buyers, HttpStatus.OK);
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
