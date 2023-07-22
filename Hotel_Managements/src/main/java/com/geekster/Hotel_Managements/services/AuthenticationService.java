package com.geekster.Hotel_Managements.services;

import com.geekster.Hotel_Managements.model.Authentication;
import com.geekster.Hotel_Managements.model.Customer;
import com.geekster.Hotel_Managements.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo authenticationRepo;
    public void savetoken(Authentication authentication) {
        authenticationRepo.save(authentication);
    }

    public Authentication getToken(Customer customer) {
   return authenticationRepo.findByCustomer(customer);
    }
}
