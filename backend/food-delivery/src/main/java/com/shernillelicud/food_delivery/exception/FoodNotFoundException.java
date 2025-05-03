package com.shernillelicud.food_delivery.exception;

public class FoodNotFoundException extends RuntimeException{

    public FoodNotFoundException() {
        super("Food not found");
    }

}
