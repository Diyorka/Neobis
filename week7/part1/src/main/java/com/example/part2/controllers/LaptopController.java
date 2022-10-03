package com.example.part2.controllers;

import com.example.part2.models.Laptop;
import com.example.part2.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }


    @GetMapping
    public ResponseEntity<List<Laptop>> getLaptops(){
        return new ResponseEntity<>(laptopService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLaptopById(@PathVariable int id){
        return laptopService.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addLaptop(Laptop laptop){
        return laptopService.addLaptop(laptop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLaptop(@PathVariable int id, Laptop newLaptop){
        return laptopService.updateLaptop(id, newLaptop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable int id){
        return laptopService.deleteLaptop(id);
    }
}
