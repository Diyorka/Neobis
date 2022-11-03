package com.example.week11.services;

import com.example.week11.models.Worker;
import com.example.week11.repositories.WorkersRepository;
import com.example.week11.util.NotFoundException;
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
        worker.setRole("ROLE_ADMIN");
        workersRepository.save(worker);
    }

    @Transactional
    public void updateWorker(int id, Worker newWorker){
        Optional<Worker> worker = workersRepository.findById(id);
        if(worker.isPresent()) {
            newWorker.setId(worker.get().getId());
            newWorker.setRole("ROLE_ADMIN");
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
