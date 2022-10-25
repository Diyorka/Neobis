package com.example.week9.util;

import com.example.week9.dto.BuyerDTO;
import com.example.week9.models.Buyer;
import com.example.week9.services.BuyersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BuyerValidation implements Validator {
    private final BuyersService buyersService;

    @Autowired
    public BuyerValidation(BuyersService buyersService) {
        this.buyersService = buyersService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Buyer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BuyerDTO buyerDTO = (BuyerDTO) target;

        if(buyersService.findBuyerByUsername(buyerDTO.getUsername()).isEmpty())
            return;

        errors.rejectValue("username", "", "Buyer with this username already exists!");
    }
}
