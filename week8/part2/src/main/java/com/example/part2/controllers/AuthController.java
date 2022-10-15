package com.example.part2.controllers;

import com.example.part2.models.Buyer;
import com.example.part2.services.RegistrationService;
import com.example.part2.util.BuyerValidation;
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

    @Autowired
    public AuthController(RegistrationService registrationService, BuyerValidation buyerValidation) {
        this.registrationService = registrationService;
        this.buyerValidation = buyerValidation;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("buyer") Buyer buyer){
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("buyer") @Valid Buyer buyer,
                                      BindingResult bindingResult){
        buyerValidation.validate(buyer, bindingResult);

        if(bindingResult.hasErrors())
            return "/auth/registration";

        registrationService.register(buyer);

        return "redirect:/auth/login";
    }


}
