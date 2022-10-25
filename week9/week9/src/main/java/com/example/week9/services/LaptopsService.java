package com.example.week9.services;

import com.example.week9.models.Laptop;
import com.example.week9.repositories.LaptopsRepository;
import com.example.week9.util.NotFoundException;
import com.example.week9.util.NotUpdatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopsService {
    private final LaptopsRepository laptopRepository;

    @Autowired
    public LaptopsService(LaptopsRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    public Laptop findById(int id){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        return laptop.orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void addLaptop(Laptop laptop){
        laptopRepository.save(laptop);
    }

    @Transactional
    public void updateLaptop(int id, Laptop newLaptop){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if(laptop.isPresent()) {
            newLaptop.setId(laptop.get().getId());
            laptopRepository.save(newLaptop);
        }else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void deleteLaptop(int id){
        if(laptopRepository.findById(id).isPresent()) {
            laptopRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

}
