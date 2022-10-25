package com.example.week9.repositories;

import com.example.week9.models.Buyer;
import com.example.week9.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkersRepository extends JpaRepository<Worker, Integer> {
    Optional<Worker> findWorkerByUsername(String username);
}
