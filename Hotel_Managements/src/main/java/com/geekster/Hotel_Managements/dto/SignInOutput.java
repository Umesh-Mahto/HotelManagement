package com.geekster.Hotel_Managements.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInOutput {
    private String message;
    private String tokenUuid;
}
