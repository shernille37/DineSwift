package com.shernillelicud.food_delivery.controller.user;

import com.shernillelicud.food_delivery.dto.user.UserDto;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.request.user.NewAddressRequest;
import com.shernillelicud.food_delivery.response.ApiResponse;
import com.shernillelicud.food_delivery.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;


    @GetMapping("/profile")
    public ResponseEntity<ApiResponse> getProfile(@RequestHeader("Authorization") String bearerToken) {

        User user = userService.findUserByJwtToken(bearerToken);
        UserDto userDto = userService.convertToDto(user);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(userDto)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/addresses")
    public ResponseEntity<ApiResponse> addAddress(@RequestHeader("Authorization") String bearerToken, @RequestBody NewAddressRequest request) {

        User authUser = userService.findUserByJwtToken(bearerToken);

        User user = userService.addAddress(request, authUser);
        UserDto userDto = userService.convertToDto(user);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Address added successfully")
                .data(userDto.getAddresses())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);


    }

}
