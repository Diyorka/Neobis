package com.example.week9.services;

import com.example.week9.models.Buyer;
import com.example.week9.repositories.BuyersRepository;
import com.example.week9.security.BuyerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerDetailsService implements UserDetailsService {
    private final BuyersRepository buyersRepository;

    @Autowired
    public BuyerDetailsService(BuyersRepository buyersRepository) {
        this.buyersRepository = buyersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Buyer> buyer = buyersRepository.findBuyerByUsername(username);
        if(buyer.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new BuyerDetails(buyer.get());
    }
}
