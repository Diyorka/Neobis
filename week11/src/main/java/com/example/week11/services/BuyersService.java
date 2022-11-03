package com.example.week11.services;

import com.example.week11.models.Buyer;
import com.example.week11.repositories.BuyersRepository;
import com.example.week11.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BuyersService {
    private final BuyersRepository buyerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BuyersService(BuyersRepository buyerRepository, PasswordEncoder passwordEncoder) {
        this.buyerRepository = buyerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Buyer> findAll(){
        return buyerRepository.findAll();
    }

    public Buyer findById(int id){
        Optional<Buyer> buyer = buyerRepository.findById(id);
        return buyer.orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void addBuyer(Buyer buyer){
        buyer.setRole("ROLE_USER");
        buyer.setPassword(passwordEncoder.encode(buyer.getPassword()));
        buyerRepository.save(buyer);
    }

    @Transactional
    public void updateBuyer(int id, Buyer newBuyer){
        Optional<Buyer> buyer = buyerRepository.findById(id);
        if(buyer.isPresent()) {
            newBuyer.setId(buyer.get().getId());
            newBuyer.setRole(buyer.get().getRole());
            buyerRepository.save(newBuyer);
        }else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void deleteById(int id){
        if(buyerRepository.findById(id).isPresent()) {
            buyerRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    public Optional<Buyer> findBuyerByUsername(String username){
        return buyerRepository.findBuyerByUsername(username);
    }

}
