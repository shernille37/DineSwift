package com.shernillelicud.food_delivery.exception;

public class CartItemNotFoundException extends RuntimeException{

    public CartItemNotFoundException() {
        super("Cart Item not found");
    }
}
