package com.shernillelicud.food_delivery.dto.food;

import com.shernillelicud.food_delivery.dto.restaurant.RestaurantDto;
import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.model.Ingredient;
import com.shernillelicud.food_delivery.model.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {

    private Long id;

    private String name;

    private String description;

    private Long price;

    private CategoryDto category;

    private RestaurantDto restaurant;

    private List<String> images = new ArrayList<>();

    private Boolean isAvailable;

    private Boolean isVegetarian;

    private Boolean isSeasonal;

    private List<IngredientDto> ingredients = new ArrayList<>();

    private Date createdAt;

}
