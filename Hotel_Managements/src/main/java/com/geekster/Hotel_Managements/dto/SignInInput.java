package com.geekster.Hotel_Managements.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInInput {
    private String userEmail;
    private String password;
}
