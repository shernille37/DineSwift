package com.shernillelicud.food_delivery.exception;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException() {
        super("Category not found");
    }

}
