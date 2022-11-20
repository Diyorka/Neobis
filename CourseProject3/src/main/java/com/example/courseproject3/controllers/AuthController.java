package com.example.courseproject3.controllers;

import com.example.courseproject3.dto.BuyerDTO;
import com.example.courseproject3.models.Buyer;
import com.example.courseproject3.services.RegistrationService;
import com.example.courseproject3.util.BuyerValidation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final RegistrationService registrationService;
    private final BuyerValidation buyerValidation;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(RegistrationService registrationService, BuyerValidation buyerValidation, ModelMapper modelMapper) {
        this.registrationService = registrationService;
        this.buyerValidation = buyerValidation;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("buyerDTO") BuyerDTO buyerDTO){
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("buyerDTO") @Valid BuyerDTO buyerDTO,
                                      BindingResult bindingResult){
        buyerValidation.validate(buyerDTO, bindingResult);

        if(bindingResult.hasErrors())
            return "/auth/registration";

        registrationService.registerBuyer(convertToBuyer(buyerDTO));
        return "redirect:/auth/login";
    }

    private Buyer convertToBuyer(BuyerDTO buyerDTO) {
        return modelMapper.map(buyerDTO, Buyer.class);
    }

}
