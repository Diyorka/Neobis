package com.example.week11.services;

import com.example.week11.models.Buyer;
import com.example.week11.repositories.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final BuyersRepository buyersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(BuyersRepository buyersRepository, PasswordEncoder passwordEncoder) {
        this.buyersRepository = buyersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerBuyer(Buyer buyer){
        buyer.setPassword(passwordEncoder.encode(buyer.getPassword()));
        buyer.setRole("ROLE_USER");
        buyersRepository.save(buyer);
    }

}
