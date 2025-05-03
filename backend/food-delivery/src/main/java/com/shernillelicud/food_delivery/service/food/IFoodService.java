package com.shernillelicud.food_delivery.service.food;

import com.shernillelicud.food_delivery.dto.food.FoodDto;
import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.model.Food;
import com.shernillelicud.food_delivery.model.Restaurant;
import com.shernillelicud.food_delivery.request.food.NewFoodRequest;

import java.util.List;

public interface IFoodService {

    public Food addFood(NewFoodRequest request);

    public void deleteFood(Long id);

    public List<Food> getAllFoodRestaurant(Long restaurantId, Boolean isVegetarian, Boolean isSeasonal, String category);

    public List<Food> searchFood(String keyword);

    public Food updateAvailabilityStatus(Long id);

    public FoodDto convertToDto(Food food);
}
