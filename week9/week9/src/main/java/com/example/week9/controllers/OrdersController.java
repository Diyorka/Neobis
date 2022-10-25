package com.example.week9.controllers;

import com.example.week9.dto.OrderDTO;
import com.example.week9.models.Order;
import com.example.week9.services.OrdersService;
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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService orderService;
    private final ModelMapper modelMapper;

    @Autowired
    public OrdersController(OrdersService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<OrderDTO> getOrders(){
        return orderService.findAll().stream().map(this::convertToOrderDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable int id){
        return convertToOrderDTO(orderService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> addOrder(@RequestBody OrderDTO orderDTO,
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

        orderService.addOrder(convertToOrder(orderDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable int id,
                                                  @RequestBody OrderDTO orderDTO,
                                                  BindingResult bindingResult) {
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

        orderService.updateOrder(id, convertToOrder(orderDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable int id){
        orderService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotFoundException e){
        ErrorResponse response = new ErrorResponse("Order with this id wasn't found");
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

    private OrderDTO convertToOrderDTO(Order order){
        return modelMapper.map(order, OrderDTO.class);
    }

    private Order convertToOrder(OrderDTO orderDTO){
        return modelMapper.map(orderDTO, Order.class);
    }
}
