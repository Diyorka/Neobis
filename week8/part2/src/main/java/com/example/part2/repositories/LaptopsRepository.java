package com.example.part2.repositories;


import com.example.part2.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopsRepository extends JpaRepository<Laptop, Integer> {
}
