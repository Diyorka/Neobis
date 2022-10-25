package com.example.week9.controllers;

import com.example.week9.dto.WorkerDTO;
import com.example.week9.models.Worker;
import com.example.week9.services.RegistrationService;
import com.example.week9.services.WorkersService;
import com.example.week9.util.ErrorResponse;
import com.example.week9.util.NotAddedException;
import com.example.week9.util.NotFoundException;
import com.example.week9.util.NotUpdatedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workers")
public class WorkersController {
    private final WorkersService workersService;
    private final ModelMapper modelMapper;

    @Autowired
    public WorkersController(WorkersService workersService, ModelMapper modelMapper) {
        this.workersService = workersService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<WorkerDTO> getWorkers(){
        return workersService.findAll().stream().map(this::convertToWorkerDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WorkerDTO getWorkerById(@PathVariable int id){
        return convertToWorkerDTO(workersService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> addWorker(@RequestBody @Valid WorkerDTO workerDTO,
                                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }

            throw new NotAddedException(errorMsg.toString());
        }

        workersService.addWorker(convertToWorker(workerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateWorker(@PathVariable int id,
                                                   @RequestBody @Valid WorkerDTO workerDTO,
                                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error:errors){
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new NotUpdatedException(errorMsg.toString());
        }
        workersService.updateWorker(id, convertToWorker(workerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWorker(@PathVariable int id){
        workersService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotFoundException e){
        ErrorResponse response = new ErrorResponse("Worker with this id wasn't found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotAddedException e){
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotUpdatedException e){
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private WorkerDTO convertToWorkerDTO(Worker worker){
        return modelMapper.map(worker, WorkerDTO.class);
    }

    private Worker convertToWorker(WorkerDTO workerDTO){
        return modelMapper.map(workerDTO, Worker.class);
    }
}
