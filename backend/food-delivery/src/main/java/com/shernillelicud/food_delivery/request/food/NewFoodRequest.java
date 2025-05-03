package com.shernillelicud.food_delivery.request.food;

import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.model.Ingredient;
import com.shernillelicud.food_delivery.model.Restaurant;
import lombok.Data;

import java.util.List;

@Data
public class NewFoodRequest {

    private String name;

    private String description;

    private Long price;

    private Category category;

    private Restaurant restaurant;

    private List<String> images;

    private Boolean isVegetarian;

    private Boolean isSeasonal;

    private List<Ingredient> ingredients;
}
