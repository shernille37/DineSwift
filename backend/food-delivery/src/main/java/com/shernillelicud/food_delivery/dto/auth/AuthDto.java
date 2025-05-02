package com.shernillelicud.food_delivery.dto.auth;

import com.shernillelicud.food_delivery.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {

    private String token;

    private String firstname;
    private String lastname;

    private String email;

    private Role role;



}
