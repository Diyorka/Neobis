package com.example.part2.services;

import com.example.part2.models.Worker;
import com.example.part2.repositories.WorkersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkersService {
    private final WorkersRepository workersRepository;

    @Autowired
    public WorkersService(WorkersRepository workersRepository) {
        this.workersRepository = workersRepository;
    }

    public ResponseEntity<List<Worker>> findAll(){
        return new ResponseEntity<>(workersRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findById(int id){
        Optional<Worker> worker = workersRepository.findById(id);
        if(worker.isEmpty())
            return new ResponseEntity<>("Worker wasn't found!", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(worker.get(), HttpStatus.OK);
    }

    public ResponseEntity<String> addWorker(Worker worker){
        try{
            workersRepository.save(worker);
            return new ResponseEntity<>("Worker was saved!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Worker wasn't saved!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateWorker(int id, Worker newWorker){
        Optional<Worker> worker = workersRepository.findById(id);
        if(worker.isEmpty())
            return new ResponseEntity<>("Worker wasn't found", HttpStatus.NOT_FOUND);
        newWorker.setId(worker.get().getId());
        try{
            workersRepository.save(newWorker);
            return new ResponseEntity<>("Worker was updated!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Worker wasn't updated", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteWorker(int id){
        Optional<Worker> worker = workersRepository.findById(id);
        if(worker.isEmpty())
            return new ResponseEntity<>("Worker wasn't found!", HttpStatus.NOT_FOUND);
        try{
            workersRepository.deleteById(id);
            return new ResponseEntity<>("Worker was deleted!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Worker wasn't deleted!", HttpStatus.BAD_REQUEST);
        }
    }

}
