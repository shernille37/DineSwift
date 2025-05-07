package com.shernillelicud.food_delivery.request.cart;

import com.shernillelicud.food_delivery.model.Food;
import com.shernillelicud.food_delivery.model.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class NewCartItemRequest {

    private Food food;

    private Integer quantity;

    private List<Ingredient> ingredients;


}
