package com.shernillelicud.food_delivery.service.ingredient;

import com.shernillelicud.food_delivery.model.Ingredient;
import com.shernillelicud.food_delivery.request.ingredient.NewIngredientRequest;

import java.util.List;

public interface IIngredientService {

    public Ingredient createIngredient(NewIngredientRequest request);

    public List<Ingredient> getAllIngredients();

}
