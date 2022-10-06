package com.example.part1.repositories;

import com.example.part1.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<Worker, Integer> {
}
