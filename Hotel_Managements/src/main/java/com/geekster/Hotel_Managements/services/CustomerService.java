package com.geekster.Hotel_Managements.services;

import com.geekster.Hotel_Managements.dto.SignInInput;
import com.geekster.Hotel_Managements.dto.SignInOutput;
import com.geekster.Hotel_Managements.dto.SignUpInput;
import com.geekster.Hotel_Managements.dto.SignupOutput;
import com.geekster.Hotel_Managements.model.Authentication;
import com.geekster.Hotel_Managements.model.Customer;
import com.geekster.Hotel_Managements.repository.ICustomerRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CustomerService {
    @Autowired
    ICustomerRepo customerRepo;
    @Autowired
    AuthenticationService authenticationService;

    public SignupOutput signUp(SignUpInput signUpInputDto) {
        Customer customer = customerRepo.findFirstByCustomerEmail(signUpInputDto.getUserEmail());
        if (customer != null) {
            throw new IllegalStateException("Email allReady Exists");
        }

        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpInputDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


        customer = new Customer(signUpInputDto.getUserEmail(), encryptedPassword, signUpInputDto.getUserFirstName(), signUpInputDto.getUserLastName(), signUpInputDto.getUserAddress(), signUpInputDto.getUserContact());
        customerRepo.save(customer);

        Authentication authentication = new Authentication(customer);
        authenticationService.savetoken(authentication);
        return new SignupOutput("signUp successfully", "now you can sign in");
    }


    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInInputDto) {
        Customer customer = customerRepo.findFirstByCustomerEmail(signInInputDto.getUserEmail());
        if (customer == null) {
            throw new IllegalStateException("sorry...!!Email not found");
        }


        String encryptedPassword ;
        try {
            encryptedPassword = encryptPassword(signInInputDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        boolean isPasswordValid = encryptedPassword.equals(customer.getCustomerPassword());
        if (!isPasswordValid) {
            throw new IllegalStateException("invalid user ...!! wrong password");
        }
        Authentication authentication = authenticationService.getToken(customer);

        return new SignInOutput("user signIn successfully", authentication.getAuthenticationToken());
    }
}
