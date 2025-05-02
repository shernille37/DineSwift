package com.shernillelicud.food_delivery.service.auth;

import com.shernillelicud.food_delivery.dto.auth.AuthDto;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.request.auth.LoginRequest;
import com.shernillelicud.food_delivery.request.auth.RegisterRequest;

public interface IAuthService {

    public User register(RegisterRequest request) throws Exception;
    public User auth(LoginRequest request);

    public AuthDto convertToDto(User user);

}
