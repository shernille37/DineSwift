package com.shernillelicud.food_delivery.exception;

public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException() {
        super("Cart not found");
    }
}
