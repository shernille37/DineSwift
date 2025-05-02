package com.shernillelicud.food_delivery.request.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginRequest {

    private String email;

    private String password;

}
