package com.example.week10.controllers;

import com.example.week10.dto.AuthenticationDTO;
import com.example.week10.dto.BuyerDTO;
import com.example.week10.models.Buyer;
import com.example.week10.security.JWTUtil;
import com.example.week10.services.RegistrationService;
import com.example.week10.util.BuyerValidation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final RegistrationService registrationService;
    private final BuyerValidation buyerValidation;
    private final ModelMapper modelMapper;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(RegistrationService registrationService, BuyerValidation buyerValidation, ModelMapper modelMapper, JWTUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.registrationService = registrationService;
        this.buyerValidation = buyerValidation;
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
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
    public Map<String, String> performRegistration(@RequestBody @Valid BuyerDTO buyerDTO,
                                      BindingResult bindingResult){
        buyerValidation.validate(buyerDTO, bindingResult);

        if(bindingResult.hasErrors())
            return Map.of("message", "Ошибка!");

        registrationService.registerBuyer(convertToBuyer(buyerDTO));
        String token = jwtUtil.generateToken(buyerDTO.getUsername());
        return Map.of("jwt-token", token);
    }

    @PostMapping("/login")
    public Map<String, String> performLogin(@RequestBody AuthenticationDTO authenticationDTO){
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),
                        authenticationDTO.getPassword());

        try {
            authenticationManager.authenticate(authInputToken);
        }catch (BadCredentialsException e){
            return Map.of("message", "Incorrect credentials");
        }

        String token = jwtUtil.generateToken(authenticationDTO.getUsername());
        return Map.of("jwt-token", token);
    }

    private Buyer convertToBuyer(BuyerDTO buyerDTO) {
        return modelMapper.map(buyerDTO, Buyer.class);
    }

}
