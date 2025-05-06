package com.shernillelicud.food_delivery.request.ingredient;

import com.shernillelicud.food_delivery.model.IngredientCategory;
import lombok.Data;

@Data
public class NewIngredientRequest {

    private IngredientCategory ingredientCategory;

    private String name;

}
