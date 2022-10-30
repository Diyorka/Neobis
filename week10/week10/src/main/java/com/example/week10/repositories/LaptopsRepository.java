package com.example.week10.repositories;


import com.example.week10.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopsRepository extends JpaRepository<Laptop, Integer> {
}
