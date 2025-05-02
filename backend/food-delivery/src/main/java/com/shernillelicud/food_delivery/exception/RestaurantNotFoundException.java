package com.shernillelicud.food_delivery.exception;

public class RestaurantNotFoundException extends RuntimeException{

    public RestaurantNotFoundException() {
        super("Restaurant not found");
    }

    public RestaurantNotFoundException(String message) {
        super(message);
    }

}
