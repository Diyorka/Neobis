package com.example.part2.repositories;

import com.example.part2.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<Worker, Integer> {
}
