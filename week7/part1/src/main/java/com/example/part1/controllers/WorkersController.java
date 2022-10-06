package com.example.part1.controllers;

import com.example.part1.models.Worker;
import com.example.part1.services.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkersController {
    private final WorkersService workersService;

    @Autowired
    public WorkersController(WorkersService workersService) {
        this.workersService = workersService;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers(){
        return workersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkerById(@PathVariable int id){
        return workersService.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addWorker(Worker worker){
        return workersService.addWorker(worker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWorker(@PathVariable int id, Worker worker){
        return workersService.updateWorker(id, worker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorker(@PathVariable int id){
        return workersService.deleteWorker(id);
    }
}
