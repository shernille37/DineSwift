package com.shernillelicud.food_delivery.exception;

import com.shernillelicud.food_delivery.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiResponse> userNotFound(UsernameNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ApiResponse> restaurantNotFound(RestaurantNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IngredientNotFoundException.class)
    public ResponseEntity<ApiResponse> ingredientNotFound(IngredientNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ApiResponse> cartNotFound(CartNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CartItemNotFoundException.class)
    public ResponseEntity<ApiResponse> cartItemNotFound(CartItemNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiResponse> categoryNotFound(CategoryNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<ApiResponse> foodNotFound(FoodNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse> badCredentials(BadCredentialsException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> runTimeError(Exception e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> generalError(Exception e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
