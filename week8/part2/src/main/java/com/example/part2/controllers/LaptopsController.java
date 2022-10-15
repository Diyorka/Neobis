package com.example.part2.controllers;

import com.example.part2.models.Laptop;
import com.example.part2.services.LaptopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/laptops")
public class LaptopsController {
    private final LaptopsService laptopService;

    @Autowired
    public LaptopsController(LaptopsService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/list")
    public String laptopsPage(){
        return "laptops";
    }

    @GetMapping
    public ResponseEntity<List<Laptop>> getLaptops(){
        return laptopService.findAll();
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
