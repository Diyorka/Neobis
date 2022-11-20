package com.example.courseproject3.repositories;

import com.example.courseproject3.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkersRepository extends JpaRepository<Worker, Integer> {
    Optional<Worker> findWorkerByUsername(String username);
}
