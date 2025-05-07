package com.shernillelicud.food_delivery.exception;

public class IngredientNotFoundException extends RuntimeException{

    public IngredientNotFoundException() {
        super("Ingredient not found");
    }

}
