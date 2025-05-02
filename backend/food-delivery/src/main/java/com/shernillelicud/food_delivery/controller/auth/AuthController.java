package com.shernillelicud.food_delivery.controller.auth;


import com.shernillelicud.food_delivery.dto.auth.AuthDto;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.request.auth.LoginRequest;
import com.shernillelicud.food_delivery.request.auth.RegisterRequest;
import com.shernillelicud.food_delivery.response.ApiResponse;
import com.shernillelicud.food_delivery.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) throws Exception {

        User user = authService.register(request);
        AuthDto authDto = authService.convertToDto(user);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Registered successfully")
                .data(authDto)
                .build();


        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> auth(@RequestBody LoginRequest request) {

        User user =  authService.auth(request);
        AuthDto authDto = authService.convertToDto(user);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Logged in Successfully")
                .data(authDto)
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);

    }


}
