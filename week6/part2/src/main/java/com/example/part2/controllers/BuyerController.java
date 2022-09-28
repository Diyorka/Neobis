package com.example.part2.controllers;

import com.example.part2.model.Buyer;
import com.example.part2.repository.BuyerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {
    @Autowired
    private BuyerRepository buyerRepository;

    @PostMapping("/new")
    public Buyer addBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @GetMapping()
    public List<Buyer> getAllBuyers(){
        return new ArrayList<>(buyerRepository.findAll());
    }

    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable int id){
        return buyerRepository.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Buyer updateBuyer(@PathVariable int id, Buyer newBuyer){
        Buyer buyer = buyerRepository.findById(id).orElse(null);
        buyer.setFirstName(newBuyer.getFirstName());
        buyer.setLastName(newBuyer.getLastName());
        buyer.setPhoneNumber(newBuyer.getPhoneNumber());
        return buyerRepository.save(newBuyer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBuyer(@PathVariable int id){
        buyerRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
