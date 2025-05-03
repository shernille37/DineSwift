package com.shernillelicud.food_delivery.service.food;

import com.shernillelicud.food_delivery.dto.food.FoodDto;
import com.shernillelicud.food_delivery.exception.CategoryNotFoundException;
import com.shernillelicud.food_delivery.exception.FoodNotFoundException;
import com.shernillelicud.food_delivery.exception.RestaurantNotFoundException;
import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.model.Food;
import com.shernillelicud.food_delivery.model.Ingredient;
import com.shernillelicud.food_delivery.model.Restaurant;
import com.shernillelicud.food_delivery.repository.food.CategoryRepository;
import com.shernillelicud.food_delivery.repository.food.FoodRepository;
import com.shernillelicud.food_delivery.repository.food.IngredientRepository;
import com.shernillelicud.food_delivery.repository.restaurant.RestaurantRepository;
import com.shernillelicud.food_delivery.request.food.NewFoodRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService implements IFoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;


    @Override
    public Food addFood(NewFoodRequest request) {

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurant().getId())
                .orElseThrow(RestaurantNotFoundException::new);

        Category category = categoryRepository.findById(request.getCategory().getId())
                .orElseThrow(CategoryNotFoundException::new);


        if(request.getIngredients() != null) {
            request.getIngredients().forEach(ingredientRepository::save);
        }

        Food newFood = new Food();
        modelMapper.map(request, newFood);

        newFood.setRestaurant(restaurant);
        newFood.setCategory(category);

        Food savedFood = foodRepository.save(newFood);

        restaurant.getFoods().add(savedFood);

        restaurantRepository.save(restaurant);

        return savedFood;
    }

    @Override
    public void deleteFood(Long id) {

        Food food = foodRepository.findById(id)
                .orElseThrow(FoodNotFoundException::new);

        food.setRestaurant(null);

        foodRepository.save(food);

    }

    @Override
    public List<Food> getAllFoodRestaurant(Long restaurantId, Boolean isVegetarian, Boolean isSeasonal, String category) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(RestaurantNotFoundException::new);

        List<Food> foodList = foodRepository.findByRestaurantId(restaurantId);

        if(isVegetarian) {
            foodList = foodRepository.findByIsVegetarianTrue();
        } else if (isSeasonal) {
            foodList = foodRepository.findByIsSeasonalTrue();
        } else {
            foodList = foodRepository.findByCategoryName(category);
        }

        return foodList;
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepository.searchFood(keyword);
    }

    @Override
    public Food updateAvailabilityStatus(Long id) {

        Food food = foodRepository.findById(id)
                .orElseThrow(FoodNotFoundException::new);

        food.setIsAvailable(!food.getIsAvailable());

        return foodRepository.save(food);
    }

    @Override
    public FoodDto convertToDto(Food food) {
            FoodDto foodDto = new FoodDto();
            modelMapper.map(food, foodDto);

            return foodDto;
    }
}
