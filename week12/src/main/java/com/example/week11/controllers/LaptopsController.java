package com.example.week11.controllers;

import com.example.week11.dto.LaptopDTO;
import com.example.week11.models.Laptop;
import com.example.week11.services.LaptopsService;
import com.example.week11.util.ErrorResponse;
import com.example.week11.util.NotAddedException;
import com.example.week11.util.NotFoundException;
import com.example.week11.util.NotUpdatedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopsController {
    private final LaptopsService laptopService;
    private final ModelMapper modelMapper;

    @Autowired
    public LaptopsController(LaptopsService laptopService, ModelMapper modelMapper) {
        this.laptopService = laptopService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<Laptop> getLaptops(){
        return laptopService.findAll();
    }

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable("id") int id){
        return laptopService.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> addLaptop(@RequestBody @Valid LaptopDTO laptopDTO,
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

        laptopService.addLaptop(convertToLaptop(laptopDTO));
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateLaptop(@PathVariable int id,
                                               @RequestBody LaptopDTO newLaptop,
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
        laptopService.updateLaptop(id, convertToLaptop(newLaptop));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLaptop(@PathVariable int id){
        laptopService.deleteLaptop(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotFoundException e){
        ErrorResponse response = new ErrorResponse("Laptop with this id wasn't found");
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

    private Laptop convertToLaptop(LaptopDTO laptopDTO) {
        return modelMapper.map(laptopDTO, Laptop.class);
    }
}
