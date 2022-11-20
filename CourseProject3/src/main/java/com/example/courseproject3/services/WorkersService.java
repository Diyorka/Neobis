package com.example.courseproject3.services;

import com.example.courseproject3.models.Worker;
import com.example.courseproject3.repositories.WorkersRepository;
import com.example.courseproject3.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WorkersService {
    private final WorkersRepository workersRepository;

    @Autowired
    public WorkersService(WorkersRepository workersRepository) {
        this.workersRepository = workersRepository;
    }

    public List<Worker> findAll(){
        return workersRepository.findAll();
    }

    public Worker findById(int id){
        Optional<Worker> worker = workersRepository.findById(id);
        return worker.orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void addWorker(Worker worker){
        workersRepository.save(worker);
    }

    @Transactional
    public void updateWorker(int id, Worker newWorker){
        Optional<Worker> worker = workersRepository.findById(id);
        if(worker.isPresent()) {
            newWorker.setId(worker.get().getId());
        }else{
            throw new NotFoundException();
        }
    }

    @Transactional
    public void deleteById(int id){
        if(workersRepository.findById(id).isPresent()){
            workersRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }

    }

}
