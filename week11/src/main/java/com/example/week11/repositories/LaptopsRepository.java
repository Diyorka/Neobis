package com.example.week11.repositories;


import com.example.week11.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopsRepository extends JpaRepository<Laptop, Integer> {
}
