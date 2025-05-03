package com.shernillelicud.food_delivery.service.food;

import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.model.Food;
import com.shernillelicud.food_delivery.model.Restaurant;
import com.shernillelicud.food_delivery.repository.food.FoodRespository;
import com.shernillelicud.food_delivery.request.food.NewFoodRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService implements IFoodService {

    private final FoodRespository foodRespository;


    @Override
    public Food addFood(NewFoodRequest request) {
        return null;
    }

    @Override
    public void deleteFood(Long id) {

    }

    @Override
    public List<Food> getAllFoodRestaurant(Long restaurantId, Boolean isVegetarian, Boolean isSeasonal, String category) {
        return List.of();
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return List.of();
    }

    @Override
    public Food updateAvailabilityStatus(Long id) {
        return null;
    }
}
