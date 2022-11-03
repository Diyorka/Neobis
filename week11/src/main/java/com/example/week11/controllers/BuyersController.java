package com.example.week11.controllers;

import com.example.week11.dto.BuyerDTO;
import com.example.week11.models.Buyer;
import com.example.week11.services.BuyersService;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyers")
public class BuyersController {
    private final BuyersService buyerService;
    private final ModelMapper modelMapper;

    @Autowired
    public BuyersController(BuyersService buyerService, ModelMapper modelMapper) {
        this.buyerService = buyerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<BuyerDTO> getBuyers(){
        return buyerService.findAll().stream().map(this::convertToBuyerDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BuyerDTO getBuyerById(@PathVariable int id){
        return convertToBuyerDTO(buyerService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> addBuyer(@RequestBody @Valid BuyerDTO buyerDTO,
                                               BindingResult bindingResult) {
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

        buyerService.addBuyer(convertToBuyer(buyerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateBuyer(@PathVariable int id,
                                              @RequestBody @Valid BuyerDTO newBuyerDTO,
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
        buyerService.updateBuyer(id, convertToBuyer(newBuyerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBuyer(@PathVariable int id){
        buyerService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotFoundException e){
        ErrorResponse response = new ErrorResponse("Buyer with this id wasn't found");
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

    private Buyer convertToBuyer(BuyerDTO buyerDTO) {
        return modelMapper.map(buyerDTO, Buyer.class);
    }

    private BuyerDTO convertToBuyerDTO(Buyer buyer) {
        return modelMapper.map(buyer, BuyerDTO.class);
    }
}
