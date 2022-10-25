package com.example.week9.repositories;

import com.example.week9.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyersRepository extends JpaRepository<Buyer, Integer> {
    Optional<Buyer> findBuyerByUsername(String username);
}
