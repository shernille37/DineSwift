package com.shernillelicud.food_delivery.controller.user;

import com.shernillelicud.food_delivery.dto.user.UserDto;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.response.ApiResponse;
import com.shernillelicud.food_delivery.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
