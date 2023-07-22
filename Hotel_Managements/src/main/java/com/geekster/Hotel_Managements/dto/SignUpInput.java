package com.geekster.Hotel_Managements.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {
    @Email
    private String userEmail;
    private String userPassword;
    private  String userFirstName;
    private String userLastName;
    private String userAddress;
    private  String userContact;
}
