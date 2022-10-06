package com.example.part2.repositories;

import com.example.part2.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyersRepository extends JpaRepository<Buyer, Integer> {
}
