package com.example.part2.services;

import com.example.part2.models.Buyer;
import com.example.part2.repositories.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyersService {
    private final BuyersRepository buyerRepository;

    @Autowired
    public BuyersService(BuyersRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public ResponseEntity<List<Buyer>> findAll(){
        return new ResponseEntity<>(buyerRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findById(int id){
        Optional<Buyer> buyer = buyerRepository.findById(id);
        if(buyer.isEmpty())
            return new ResponseEntity<>("Laptop wasn't found!", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(buyer.get(), HttpStatus.OK);
    }

    public ResponseEntity<String> addBuyer(Buyer buyer){
        try{
            buyerRepository.save(buyer);
            return new ResponseEntity<>("Successfully saved!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Buyer wasn't saved!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateBuyer(int id, Buyer newBuyer){
        Optional<Buyer> buyer = buyerRepository.findById(id);
        if(buyer.isEmpty())
            return new ResponseEntity<>("Buyer wasn't found!", HttpStatus.NOT_FOUND);

        newBuyer.setId(buyer.get().getId());
        buyerRepository.save(newBuyer);
        return new ResponseEntity<>("Buyer was updated!", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteById(int id){
        Optional<Buyer> buyer = buyerRepository.findById(id);
        if(buyer.isEmpty())
            return new ResponseEntity<>("Buyer wasn't found!", HttpStatus.NOT_FOUND);

        try {
            buyerRepository.deleteById(id);
            return new ResponseEntity<>("Buyer was successfully deleted!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Buyer wasn't deleted!", HttpStatus.BAD_REQUEST);
        }
    }

    public Optional<Buyer> findBuyerByUsername(String username){
        return buyerRepository.findBuyerByUsername(username);
    }

}
