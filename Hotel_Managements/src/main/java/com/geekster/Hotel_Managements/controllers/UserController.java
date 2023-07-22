package com.geekster.Hotel_Managements.controllers;

import com.geekster.Hotel_Managements.dto.SignInInput;
import com.geekster.Hotel_Managements.dto.SignInOutput;
import com.geekster.Hotel_Managements.dto.SignUpInput;
import com.geekster.Hotel_Managements.dto.SignupOutput;
import com.geekster.Hotel_Managements.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class UserController {
@Autowired
CustomerService customerService;

@PostMapping("/signUp")
public SignupOutput signUp(@RequestBody SignUpInput signUpInputDto){
return customerService.signUp(signUpInputDto);
}

    @PostMapping("/signIn")
    public SignInOutput signIn(@RequestBody SignInInput SignInInputDto){
        return customerService.signIn(SignInInputDto);
    }
}
