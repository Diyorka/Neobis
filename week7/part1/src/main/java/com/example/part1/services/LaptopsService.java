package com.example.part1.services;

import com.example.part1.models.Laptop;
import com.example.part1.repositories.LaptopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopsService {
    private final LaptopsRepository laptopRepository;

    @Autowired
    public LaptopsService(LaptopsRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public ResponseEntity<List<Laptop>> findAll(){
        return new ResponseEntity<>(laptopRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findById(int id){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if(laptop.isEmpty())
            return new ResponseEntity<>("Laptop wasn't found!", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(laptop.get(), HttpStatus.OK);
    }

    public ResponseEntity<String> addLaptop(Laptop laptop){
        try {
            laptopRepository.save(laptop);
            return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Laptop wasn't saved!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateLaptop(int id, Laptop newLaptop){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if(laptop.isEmpty())
            return new ResponseEntity<>("Laptop wasn't found!", HttpStatus.BAD_REQUEST);

        newLaptop.setId(laptop.get().getId());
        laptopRepository.save(newLaptop);
        return new ResponseEntity<>("Successfully updated!", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteLaptop(int id){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if(laptop.isEmpty())
            return new ResponseEntity<>("Laptop wasn't found!", HttpStatus.BAD_REQUEST);

        try {
            laptopRepository.deleteById(id);
            return new ResponseEntity<>("Laptop was successfully deleted!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Laptop wasn't deleted!", HttpStatus.BAD_REQUEST);
        }
    }

}
